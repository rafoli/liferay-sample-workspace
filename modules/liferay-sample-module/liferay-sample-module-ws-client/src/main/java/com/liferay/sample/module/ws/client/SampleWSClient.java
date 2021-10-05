package com.liferay.sample.module.ws.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.ws.api.SampleWS;
import com.liferay.sample.module.ws.client.base.RestClientFactory;
import com.liferay.sample.module.ws.config.RestAPIConfiguration;
import com.liferay.sample.module.ws.exception.ApiResponseException;
import com.liferay.sample.module.ws.response.SampleResponse;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Oliveira
 */
@Component(
	configurationPid = "com.liferay.sample.module.ws.config.RestAPIConfiguration", immediate = true, property = {},
	service = SampleWSClient.class
)
public class SampleWSClient extends RestClientFactory<SampleWS> {

	public SampleResponse addSample(SampleResponse sampleObject) throws ApiResponseException {
		return _sampleWS.addSample(sampleObject);
	}

	public void deleteSample(String id) throws ApiResponseException {
		_sampleWS.deleteSample(id);
	}

	public SampleResponse getSample(String id) throws ApiResponseException {
		return _sampleWS.getSample(id);
	}

	public List<SampleResponse> getSamples() throws ApiResponseException {
		return _sampleWS.getSamples();
	}

	public SampleResponse updateSample(String id, SampleResponse sampleObject) throws ApiResponseException {
		return _sampleWS.updateSample(id, sampleObject);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		RestAPIConfiguration sampleConfig = ConfigurableUtil.createConfigurable(RestAPIConfiguration.class, properties);

		_sampleWS = _restClientFactory.getAPI(sampleConfig, SampleWS.class);
	}

	@Reference
	private RestClientFactory<SampleWS> _restClientFactory;

	private SampleWS _sampleWS;

}