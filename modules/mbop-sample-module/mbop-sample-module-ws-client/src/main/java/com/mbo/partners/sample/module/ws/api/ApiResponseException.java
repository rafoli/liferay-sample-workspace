package com.mbo.partners.sample.module.ws.api;

/**
 * @author Rafael Oliveira
 */
public class ApiResponseException extends RuntimeException {

	public ApiResponseException(String error) {
		super(error);
	}

	public ApiResponseException(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = -3699785260298215546L;

}
