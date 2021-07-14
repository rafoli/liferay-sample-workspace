package com.liferay.sample.module.ws.api;

import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.ws.response.SampleResponse;
import java.util.List;

import feign.Param;
import feign.RequestLine;
import feign.Headers;

/**
 * @author Rafael Oliveira
 */
public interface SampleWS {

   @RequestLine("GET /samples")
   List<SampleResponse> getSamples();

   @RequestLine("GET /samples?id={id}")
   SampleResponse getSample(@Param("id") String id);

   @RequestLine("POST /samples")
   @Headers("Content-Type: application/json")
   SampleResponse addSample(SampleObject sampleObject);

   @RequestLine("PUT /samples")
   SampleResponse updateSample(SampleObject sampleObject);

   @RequestLine("DELETE /samples/{id}")
   void deleteSample(@Param("id") String id);

}
