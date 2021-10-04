package com.liferay.sample.module.service.mapper;

import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.ws.response.SampleResponse;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rafael Oliveira
 */
@Component(immediate = true, service = SampleServiceMapper.class)
public class SampleServiceMapper {

	public SampleObject toSampleObject(SampleResponse entity) {
		SampleObject sampleObject = new SampleObject();

		sampleObject.setId(entity.getId());
		sampleObject.setName(entity.getName());

		return sampleObject;
	}

	public List<SampleObject> toSampleObjects(List<SampleResponse> entities) {
		List<SampleObject> objects = new ArrayList<>();

		for (SampleResponse entity : entities) {
			SampleObject object = toSampleObject(entity);

			objects.add(object);
		}

		return objects;
	}

	public SampleResponse toSampleResponse(SampleObject sampleObject) {
		SampleResponse sampleResponse = new SampleResponse();
		sampleResponse.setName(sampleObject.getName());
		return sampleResponse;
	}
}