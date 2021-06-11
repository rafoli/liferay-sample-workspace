package com.liferay.sample.module.service;

import com.liferay.sample.module.model.SampleObject;

import java.util.List;

/**
 * @author Rafael Oliveira
 */
public interface SampleService {

    public List<SampleObject> getSamples();
    public SampleObject addSample(String id, String name);

}
