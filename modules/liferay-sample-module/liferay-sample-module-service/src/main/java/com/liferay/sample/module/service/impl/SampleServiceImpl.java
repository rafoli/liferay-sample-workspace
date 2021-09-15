package com.liferay.sample.module.service.impl;

import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.service.SampleService;
import com.liferay.sample.module.service.mapper.SampleServiceMapper;
import com.liferay.sample.module.ws.client.SampleWSClient;
import com.liferay.sample.module.ws.response.SampleResponse;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Oliveira
 */
@Component(immediate = true, service = SampleService.class)
public class SampleServiceImpl implements SampleService {

	@Override
	public SampleObject addSample(SampleObject sampleObject) {
		try {
			SampleResponse entity = _sampleWSClient.addSample(sampleObject);

			return _sampleServiceMapper.toSampleObject(entity);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteSample(String id) {
		_sampleWSClient.deleteSample(id);
	}

	@Override
	public SampleObject getSample(String id) {
		SampleResponse entity = _sampleWSClient.getSample(id);

		return _sampleServiceMapper.toSampleObject(entity);
	}

	public List<SampleObject> getSamples() {
		try {
			List<SampleResponse> entities = _sampleWSClient.getSamples();

			return _sampleServiceMapper.toSampleObjects(entities);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

	@Override
	public SampleObject updateSample(SampleObject sampleObject) {
		try {
			SampleResponse entity = _sampleWSClient.updateSample(sampleObject);

			return _sampleServiceMapper.toSampleObject(entity);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}

	@Reference
	private SampleServiceMapper _sampleServiceMapper;

	@Reference
	private SampleWSClient _sampleWSClient;

}