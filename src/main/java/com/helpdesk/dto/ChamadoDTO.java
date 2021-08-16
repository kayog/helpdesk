package com.helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.helpdesk.domain.Chamado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamadoDTO implements Serializable {
	
	private static final long serialVersionUID = 8601676262796989096L;
	
	private Integer id;
	private Integer prioridade;
	@NotEmpty(message = "O campo Observações é requerido.")
	private String observacoes;
	private Integer status;
	private Integer tecnico;
	private Integer cliente;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	public ChamadoDTO() {
		super();
	}

	public ChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.prioridade = obj.getPrioridade().getCod();
		this.observacoes = obj.getObservacoes();
		this.status = obj.getStatus().getCod();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
	}

}
