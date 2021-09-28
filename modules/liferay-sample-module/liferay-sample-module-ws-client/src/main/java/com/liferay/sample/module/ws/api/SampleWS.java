package com.liferay.sample.module.ws.api;

import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.ws.response.SampleResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @author Rafael Oliveira
 */
public interface SampleWS {

	@Headers("Content-Type: application/json")
	@RequestLine("POST /samples")
	public SampleResponse addSample(SampleObject sampleObject);

	@RequestLine("DELETE /samples/{id}")
	public void deleteSample(@Param("id") String id);

	@RequestLine("GET /samples/{id}")
	public SampleResponse getSample(@Param("id") String id);

	@RequestLine("GET /samples")
	public List<SampleResponse> getSamples();

	@RequestLine("PUT /samples")
	public SampleResponse updateSample(SampleObject sampleObject);

}