package com.liferay.sample.module.ws.api;

import com.liferay.sample.module.ws.response.SampleResponse;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author Rafael Oliveira
 */
public interface SampleWS {

	@Headers("Content-Type: application/json")
	@RequestLine("POST /samples")
	public SampleResponse addSample(SampleResponse sampleObject);

	@RequestLine("DELETE /samples/{id}")
	public void deleteSample(@Param("id") String id);

	@RequestLine("GET /samples/{id}")
	public SampleResponse getSample(@Param("id") String id);

	@RequestLine("GET /samples")
	public List<SampleResponse> getSamples();
	
	@Headers("Content-Type: application/json")
	@RequestLine("PUT /samples/{id}")
	public SampleResponse updateSample(@Param("id") String id, SampleResponse sampleObject);

}