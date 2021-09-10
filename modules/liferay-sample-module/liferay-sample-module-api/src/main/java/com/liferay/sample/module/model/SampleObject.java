package com.liferay.sample.module.model;

/**
 * @author Rafael Oliveira
 */
public class SampleObject {

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