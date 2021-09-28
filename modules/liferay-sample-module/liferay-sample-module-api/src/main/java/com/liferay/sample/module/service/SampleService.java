package com.liferay.sample.module.service;

import com.liferay.sample.module.model.SampleObject;

import java.util.List;

/**
 * @author Rafael Oliveira
 */
public interface SampleService {

	public SampleObject addSample(SampleObject sampleObject);

	public void deleteSample(String id);

	public SampleObject getSample(String id);

	public List<SampleObject> getSamples();

	public SampleObject updateSample(String id, SampleObject sampleObject);

}