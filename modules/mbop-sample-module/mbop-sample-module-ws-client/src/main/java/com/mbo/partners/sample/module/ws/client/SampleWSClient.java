package com.mbo.partners.sample.module.ws.client;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.mbo.partners.sample.module.ws.api.ApiResponseException;
import com.mbo.partners.sample.module.ws.api.SampleWS;
import com.mbo.partners.sample.module.ws.client.base.RestClientFactory;
import com.mbo.partners.sample.module.ws.config.RestAPIConfiguration;
import com.mbo.partners.sample.module.ws.respose.SampleResponse;
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
        configurationPid = {"com.mbo.partners.sample.module.ws.config.RestAPIConfiguration" }
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


    private SampleWS _sampleWS;

    @Reference
    RestClientFactory<SampleWS> _restClientFactory;
}
