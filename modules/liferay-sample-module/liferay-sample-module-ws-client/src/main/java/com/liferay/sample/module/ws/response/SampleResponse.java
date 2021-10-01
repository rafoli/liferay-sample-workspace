package com.liferay.sample.module.ws.response;

/**
 * @author Rafael Oliveira
 */
public class SampleResponse {

	public String getId() {
		return resId;
	}

	public String getName() {
		return resName;
	}

	public void setId(String id) {
		this.resId = resId;
	}

	public void setName(String name) {
		this.resName = resName;
	}

	private String resId;
	private String resName;
}
