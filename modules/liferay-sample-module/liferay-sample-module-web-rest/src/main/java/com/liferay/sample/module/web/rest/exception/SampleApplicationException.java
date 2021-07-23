package com.liferay.sample.module.web.rest.exception;

public class SampleApplicationException extends Exception {

	public SampleApplicationException(String error) {
		super(error);
	}
	
	public SampleApplicationException(Exception exception) {
		super(exception);
	}

	private static final long serialVersionUID = 738747990198032593L;

}
