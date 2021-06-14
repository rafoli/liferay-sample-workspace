package com.liferay.sample.module.ws.api;

import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.ws.response.SampleResponse;
import java.util.List;
import feign.RequestLine;

/**
 * @author Rafael Oliveira
 */
public interface SampleWS {

   @RequestLine("GET")
   List<SampleResponse> getSamples();
   
   @RequestLine("POST")
   SampleResponse addSample(SampleObject sampleObject);

}
