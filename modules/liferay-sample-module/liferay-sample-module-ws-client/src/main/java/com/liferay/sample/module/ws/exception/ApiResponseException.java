package com.liferay.sample.module.ws.exception;

/**
 * @author Rafael Oliveira
 */
public class ApiResponseException extends RuntimeException {

	public ApiResponseException(Exception exception) {
		super(exception);
	}

	public ApiResponseException(String error) {
		super(error);
	}

	private static final long serialVersionUID = -3699785260298215546L;

}