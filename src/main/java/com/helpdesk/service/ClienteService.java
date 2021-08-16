package com.helpdesk.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.helpdesk.domain.Cliente;
import com.helpdesk.domain.Pessoa;
import com.helpdesk.dto.ClienteDTO;
import com.helpdesk.repository.ClienteRepository;
import com.helpdesk.repository.PessoaRepository;
import com.helpdesk.service.exception.DataIntegratyViolationException;
import com.helpdesk.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> op = repository.findById(id);
		return op.orElseThrow(()->new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + "Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente create(ClienteDTO dto) {
		if(findByCPF(dto) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado.");
		}
		return repository.save(new Cliente(null, dto.getNome(), dto.getCpf(), dto.getTelefone()));
	}
	
	public Cliente update(Integer id, @Valid ClienteDTO dto) {
		Cliente oldObj = findById(id);
		if(findByCPF(dto) != null && !findByCPF(dto).getId().equals(id)) {
			throw new DataIntegratyViolationException("CPF já cadastrado.");
		}
		
		oldObj.setNome(dto.getNome());
		oldObj.setCpf(dto.getCpf());
		oldObj.setTelefone(dto.getTelefone());
		
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Cliente t = findById(id);
		if(!t.getListaOS().isEmpty()) {
			throw new DataIntegratyViolationException("Cliente possui OS, não pode ser deletado.");
		}
		repository.deleteById(id);
	}
	
	private Pessoa findByCPF(ClienteDTO dto) {
		Pessoa obj = pessoaRepository.findByCPF(dto.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
		
	}
}
