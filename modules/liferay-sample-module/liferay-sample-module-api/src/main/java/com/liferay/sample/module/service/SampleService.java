package com.liferay.sample.module.service;

import com.liferay.sample.module.model.SampleObject;

import java.util.List;

/**
 * @author Rafael Oliveira
 */
public interface SampleService {

    List<SampleObject> getSamples();

    SampleObject addSample(SampleObject sampleObject);

    SampleObject updateSample(SampleObject sampleObject);

    void deleteSample(String id);

    SampleObject getSample(String id);
}
