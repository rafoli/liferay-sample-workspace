package liferay.openapi.rest.builder.internal.resource.v1_0;

import liferay.openapi.rest.builder.resource.v1_0.SampleResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/sample.properties",
	scope = ServiceScope.PROTOTYPE, service = SampleResource.class
)
public class SampleResourceImpl extends BaseSampleResourceImpl {
}