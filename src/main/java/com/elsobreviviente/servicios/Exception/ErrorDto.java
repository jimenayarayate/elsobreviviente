package com.elsobreviviente.servicios.Exception;

public class ErrorDto {
	private String error;

	
	
	public ErrorDto() {
		super();
	}

	public ErrorDto(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
