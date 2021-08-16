package com.helpdesk.resource.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationError extends StandardError{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5600345840422937763L;
	
	
	private List<FieldMessage> erros = new ArrayList<>();


	public ValidationError() {
		super();
	}


	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}
	
	public void addError(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}
	

}
