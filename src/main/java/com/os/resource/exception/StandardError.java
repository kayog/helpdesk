package com.os.resource.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -687752232028618427L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	
	public StandardError() {
		super();
	}

	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	
	

}
