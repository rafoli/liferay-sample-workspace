package com.liferay.sample.module.ws.config;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;


/**
 * @author Rafael Oliveira
 */
@ExtendedObjectClassDefinition(
        category = "liferay-configuration",
        scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
        id="com.liferay.sample.module.ws.config.RestAPIConfiguration",
        localization = "content/Language",
        name = "liferay-sample-ws"
)
public interface RestAPIConfiguration {

    @Meta.AD(
            deflt="sample-api",
            name = "api-name",
            required = false
    )
    public String apiName();

    @Meta.AD(
            deflt="",
            name = "api-key",
            required = false
    )
    public String apiKey();

    @Meta.AD(
            deflt="/",
            name = "api-base-url",
            required = false
    )
    public String apiBaseUrl();

    @Meta.AD(
            deflt="5",
            name = "api-timeout-seconds",
            required = false
    )
    public int apiTimeoutSeconds();
    
    @Meta.AD(
            deflt="5",
            name = "api-circuitbreaker-minimum-calls",
            required = false
    )
    public int minimumNumberOfCallsValue();
    
    @Meta.AD(
            deflt="50",
            name = "api-circuitbreaker-failure-rate-threshold",
            required = false
    )
    public int failureRateThresholdValue();
    
    @Meta.AD(
            deflt="20",
            name = "api-circuitbreaker-duration-open-state",
            required = false
    )
    public long waitDurationInOpenStateValue();
}
