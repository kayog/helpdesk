package com.os.service;

import java.util.Arrays;

import com.os.domain.Cliente;
import com.os.domain.Chamado;
import com.os.domain.Tecnico;
import com.os.domain.enuns.Prioridade;
import com.os.domain.enuns.Status;
import com.os.repository.ClienteRepository;
import com.os.repository.ChamadoRepository;
import com.os.repository.TecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository osRepository;
	
	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "Tecnico 1", "862.171.270-91", "(65) 99999-9999");
		Tecnico t2 = new Tecnico(null, "Tecnico 2", "508.268.210-57", "(65) 97777-7777");
		Cliente c1 = new Cliente(null, "CCCCC DDDD", "003.565.880-09", "(65) 98888-8888");
		
		Chamado os1 = new Chamado(Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);

		t1.getListaOS().add(os1);
		c1.getListaOS().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));	
	}

}
