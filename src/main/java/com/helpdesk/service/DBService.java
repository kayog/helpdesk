package com.helpdesk.service;

import java.util.Arrays;

import com.helpdesk.domain.Chamado;
import com.helpdesk.domain.Cliente;
import com.helpdesk.domain.Tecnico;
import com.helpdesk.domain.enuns.Prioridade;
import com.helpdesk.domain.enuns.Status;
import com.helpdesk.repository.ChamadoRepository;
import com.helpdesk.repository.ClienteRepository;
import com.helpdesk.repository.TecnicoRepository;

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
		Tecnico t1 = new Tecnico(null, "Tecnico 1", "862.171.270-91", "(65) 99999-9991");
		Tecnico t2 = new Tecnico(null, "Tecnico 2", "508.268.210-57", "(65) 99999-9992");
		Tecnico t3 = new Tecnico(null, "Tecnico 3", "905.583.260-05", "(65) 99999-9993");
		Tecnico t4 = new Tecnico(null, "Tecnico 4", "545.261.490-71", "(65) 99999-9994");
		Tecnico t5 = new Tecnico(null, "Tecnico 5", "185.426.230-02", "(65) 99999-9995");
		Tecnico t6 = new Tecnico(null, "Tecnico 6", "019.998.490-51", "(65) 99999-9996");

		Cliente c1 = new Cliente(null, "Cliente 1", "003.565.880-09", "(65) 98888-8881");
		Cliente c2 = new Cliente(null, "Cliente 2", "235.146.660-83", "(65) 98888-8882");
		Cliente c3 = new Cliente(null, "Cliente 3", "096.888.060-64", "(65) 98888-8883");
		Cliente c4 = new Cliente(null, "Cliente 4", "159.614.520-00", "(65) 98888-8884");
		Cliente c5 = new Cliente(null, "Cliente 5", "597.728.470-51", "(65) 98888-8885");
		Cliente c6 = new Cliente(null, "Cliente 6", "919.567.760-79", "(65) 98888-8886");
		
		Chamado o1 = new Chamado(Prioridade.ALTA, "Teste create OS 1", Status.ANDAMENTO, t1, c1);
		Chamado o2 = new Chamado(Prioridade.ALTA, "Teste create OS 2", Status.ANDAMENTO, t2, c2);
		Chamado o3 = new Chamado(Prioridade.ALTA, "Teste create OS 3", Status.ANDAMENTO, t3, c3);


		t1.getListaOS().add(o1);
		c1.getListaOS().add(o1);
		t2.getListaOS().add(o2);
		c2.getListaOS().add(o2);
		t3.getListaOS().add(o3);
		c3.getListaOS().add(o3);


		tecnicoRepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6));
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));
		osRepository.saveAll(Arrays.asList(o1,o2,o3));	
	}

}
