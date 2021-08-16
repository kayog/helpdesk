package com.helpdesk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Cliente extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2095843494629206417L;
	
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> listaOS = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, @CPF String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	
	

}
