package com.mbo.partners.sample.module.ws.api;

import com.mbo.partners.sample.module.ws.respose.SampleResponse;
import feign.RequestLine;

import java.util.List;

/**
 * @author Rafael Oliveira
 */
public interface SampleWS {

   @RequestLine("GET")
   List<SampleResponse> getSamples();

}
