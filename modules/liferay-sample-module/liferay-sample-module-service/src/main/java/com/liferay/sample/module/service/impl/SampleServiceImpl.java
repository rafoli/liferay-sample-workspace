package com.liferay.sample.module.service.impl;

import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.service.SampleService;
import com.liferay.sample.module.service.mapper.SampleServiceMapper;
import com.liferay.sample.module.ws.client.SampleWSClient;
import com.liferay.sample.module.ws.response.SampleResponse;

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
    
    public SampleObject addSample(SampleObject sampleObject) {
    	
    	try {
    		SampleResponse entity = _sampleWSClient.addSample(sampleObject);
            return _sampleServiceMapper.toSampleObject(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
	}
    
    public SampleObject updateSample(SampleObject sampleObject) {
    	
    	try {
    		SampleResponse entity = _sampleWSClient.updateSample(sampleObject);
    		return _sampleServiceMapper.toSampleObject(entity);
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
