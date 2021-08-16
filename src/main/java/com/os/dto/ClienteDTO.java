package com.os.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.os.domain.Cliente;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2543185267699343074L;
	
	private Integer id;
	@NotEmpty(message = "O campo Nome deve ser preenchido.")
	private String nome;
	@CPF
	@NotEmpty(message = "O campo CPF deve ser preenchido.")
	private String cpf;
	@NotEmpty(message = "O campo Telefone deve ser preenchido.")
	private String telefone;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}

}
