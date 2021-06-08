package com.mbo.partners.sample.module.service.impl;

import com.mbo.partners.sample.module.model.SampleObject;
import com.mbo.partners.sample.module.service.SampleService;
import com.mbo.partners.sample.module.service.mapper.SampleServiceMapper;
import com.mbo.partners.sample.module.ws.client.SampleWSClient;
import com.mbo.partners.sample.module.ws.respose.SampleResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

/**
 * @author Rafael Oliveira
 */
@Component(immediate = true, service = SampleService.class)
public class SampleServiceImpl implements SampleService {

    public List<SampleObject> getSamples() {


        try {
            List<SampleResponse> entities = _sampleWSClient.getSamples();
            return _sampleServiceMapper.toSampleObjects(entities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Reference
    private SampleWSClient _sampleWSClient;

    @Reference
    private SampleServiceMapper _sampleServiceMapper;

}
