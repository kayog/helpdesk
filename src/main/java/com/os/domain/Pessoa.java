package com.os.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
public abstract class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -102804765293998646L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@CPF
	private String cpf;
	private String telefone;
	
	protected Pessoa() {
		super();
	}
	
	protected Pessoa(Integer id, String nome, @CPF String cpf, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	

}
