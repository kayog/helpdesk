package com.os.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.os.domain.Pessoa;
import com.os.domain.Tecnico;
import com.os.dto.TecnicoDTO;
import com.os.repository.PessoaRepository;
import com.os.repository.TecnicoRepository;
import com.os.service.exception.DataIntegratyViolationException;
import com.os.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> op = repository.findById(id);
		return op.orElseThrow(()->new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + "Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO dto) {
		if(findByCPF(dto) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado.");
		}
		return repository.save(new Tecnico(null, dto.getNome(), dto.getCpf(), dto.getTelefone()));
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDTO dto) {
		Tecnico oldObj = findById(id);
		if(findByCPF(dto) != null && !findByCPF(dto).getId().equals(id)) {
			throw new DataIntegratyViolationException("CPF já cadastrado.");
		}
		
		oldObj.setNome(dto.getNome());
		oldObj.setCpf(dto.getCpf());
		oldObj.setTelefone(dto.getTelefone());
		
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Tecnico t = findById(id);
		if(!t.getListaOS().isEmpty()) {
			throw new DataIntegratyViolationException("Tecnico possui OS, não pode ser deletado.");
		}
		repository.deleteById(id);
	}
	
	private Pessoa findByCPF(TecnicoDTO dto) {
		Pessoa obj = pessoaRepository.findByCPF(dto.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
		
	}
}
