package com.liferay.sample.module.ws.api;

import feign.RequestLine;

import com.liferay.sample.module.ws.response.SampleResponse;

import java.util.List;

/**
 * @author Rafael Oliveira
 */
public interface SampleWS {

   @RequestLine("GET")
   List<SampleResponse> getSamples();
   
   @RequestLine("POST")
   SampleResponse addSample(String id, String name);

}
