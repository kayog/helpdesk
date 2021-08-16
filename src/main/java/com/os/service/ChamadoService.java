package com.os.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.os.domain.Chamado;
import com.os.domain.enuns.Prioridade;
import com.os.domain.enuns.Status;
import com.os.dto.ChamadoDTO;
import com.os.repository.ChamadoRepository;
import com.os.service.exception.DataIntegratyViolationException;
import com.os.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> op = repository.findById(id);
		return op.orElseThrow(()->new ObjectNotFoundException(
				"Objeto não encontrado. Id: " + id + "Tipo: " + Chamado.class.getName()));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}
	
	public Chamado create(ChamadoDTO dto) {
		return repository.save(fromDTO(dto));
	}
	
	public Chamado update(@Valid ChamadoDTO dto) {
	
		return repository.save(fromDTO(dto));
	}
	
	public void delete(Integer id) {
		Chamado os = findById(id);
		if(os.getStatus() != Status.ABERTO) {
			throw new DataIntegratyViolationException("Chamados que estão em andamento ou encerrados não podem ser exclidos");
		}
		repository.deleteById(id);
	}
	
	private Chamado fromDTO( ChamadoDTO dto) {
		Chamado os = new Chamado();
		if(dto.getId() != null) {
			os = findById(dto.getId());
		}
		
		os.setId(dto.getId());
		os.setObservacoes(dto.getObservacoes());
		os.setPrioridade(Prioridade.toEnun(dto.getPrioridade()));
		os.setStatus(Status.toEnun(dto.getStatus()));
		os.setTecnico(tecnicoService.findById(dto.getTecnico()));
		os.setCliente(clienteService.findById(dto.getCliente()));
		
		if(os.getStatus().getCod().equals(2)) {
			os.setDataFechamento(LocalDateTime.now());
		}
		
		return os;
	}
	
}
