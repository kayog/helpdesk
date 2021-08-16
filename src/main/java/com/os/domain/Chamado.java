package com.os.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.os.domain.enuns.Prioridade;
import com.os.domain.enuns.Status;

import lombok.Data;

@Entity
@Data
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer prioridade;
	private String observacoes;
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "tecnico_id",referencedColumnName = "id")
	private Tecnico tecnico;
	@ManyToOne
	@JoinColumn(name = "cliente_id",referencedColumnName = "id")
	private Cliente cliente;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	public Chamado() {
		super();
		this.setDataAbertura(LocalDateTime.now());
		this.setPrioridade(Prioridade.BAIXA);
		this.setStatus(Status.ABERTO);
	}
	
	public Chamado(Prioridade prioridade, String observacoes, Status status, 
			Tecnico tecnico, Cliente cliente) {
		super();
		this.prioridade = (prioridade == null) ? 0: prioridade.getCod();
		this.observacoes = observacoes;
		this.status =  (status == null) ? 0: status.getCod();
		this.tecnico = tecnico;
		this.cliente = cliente;
		this.setDataAbertura(LocalDateTime.now());
	}
	
	public Prioridade getPrioridade() {
		return Prioridade.toEnun(this.prioridade);
	}
	
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCod();
	}
	
	public Status getStatus() {
		return Status.toEnun(this.status);
	}
	
	public void setStatus(Status status) {
		this.status = status.getCod();
	}
	

	
	
}
