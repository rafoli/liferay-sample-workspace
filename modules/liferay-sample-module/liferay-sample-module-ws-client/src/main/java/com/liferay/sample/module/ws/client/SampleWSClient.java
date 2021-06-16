package com.liferay.sample.module.ws.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.ws.api.ApiResponseException;
import com.liferay.sample.module.ws.api.SampleWS;
import com.liferay.sample.module.ws.client.base.RestClientFactory;
import com.liferay.sample.module.ws.config.RestAPIConfiguration;
import com.liferay.sample.module.ws.response.SampleResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Rafael Oliveira
 */
@Component(immediate = true,
        property = {},
        service = SampleWSClient.class,
        configurationPid = {"com.liferay.sample.module.ws.config.RestAPIConfiguration" }
)
public class SampleWSClient extends RestClientFactory<SampleWS> {

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        RestAPIConfiguration _sampleConfig = ConfigurableUtil.createConfigurable(RestAPIConfiguration.class, properties);

        _sampleWS = (SampleWS) _restClientFactory.getAPI(_sampleConfig, SampleWS.class);
    }

    public List<SampleResponse> getSamples() throws ApiResponseException, IOException {

            return _sampleWS.getSamples();
    }

    public SampleResponse getSample(String id) throws ApiResponseException {

       return  _sampleWS.getSample(id);

    }

    public SampleResponse addSample(SampleObject sampleObject) throws ApiResponseException, IOException {

        	return _sampleWS.addSample(sampleObject);
    }

    public SampleResponse updateSample(SampleObject sampleObject) throws ApiResponseException, IOException {

    	return _sampleWS.updateSample(sampleObject);

    }

    public void deleteSample(String id) throws ApiResponseException {

    	_sampleWS.deleteSample(id);

    }

    private SampleWS _sampleWS;

    @Reference
    RestClientFactory<SampleWS> _restClientFactory;
}
