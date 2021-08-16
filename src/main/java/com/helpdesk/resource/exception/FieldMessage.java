package com.helpdesk.resource.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3615389723096407990L;

	private String fieldName;
	private String message;
	
	public FieldMessage() {
		super();
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	
}
