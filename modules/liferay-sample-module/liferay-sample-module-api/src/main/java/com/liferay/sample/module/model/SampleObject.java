package com.liferay.sample.module.model;

/**
 * @author Rafael Oliveira
 */
public class SampleObject {

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String id;
	private String name;
}