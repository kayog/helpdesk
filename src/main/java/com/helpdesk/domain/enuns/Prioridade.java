package com.helpdesk.domain.enuns;

import lombok.Getter;

@Getter
public enum Prioridade {

	BAIXA(0, "BAIXA"),
	MEDIA(1, "MEDIA"),
	ALTA(2, "ALTA");
	
	private Integer cod;
	private String descricao;
	
	private Prioridade(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static Prioridade toEnun(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Prioridade p: Prioridade.values()) {
			if(cod.equals(p.getCod()) ) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida.");
		
	}
	
	
}
