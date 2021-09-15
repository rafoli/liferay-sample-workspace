package com.liferay.sample.module.web.rest.exception;

/**
 * @author Rafael Oliveira
 */
public class SampleApplicationException extends Exception {

	public SampleApplicationException(Exception exception) {
		super(exception);
	}

	public SampleApplicationException(String error) {
		super(error);
	}

	private static final long serialVersionUID = 738747990198032593L;

}