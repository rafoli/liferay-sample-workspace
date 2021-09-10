package com.liferay.sample.module.ws.response;

/**
 * @author Rafael Oliveira
 */
public class SampleResponse {

	public String getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _id;
	private String _name;

}