package com.os.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Tecnico extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4451240385247503163L;

	@OneToMany(mappedBy = "tecnico")
	@JsonIgnore
	private List<Chamado> listaOS = new ArrayList<>();
	
	public Tecnico() {
		super();
	}
	

	public Tecnico(Integer id, String nome, @CPF String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

}
