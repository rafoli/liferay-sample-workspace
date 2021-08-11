package liferay.openapi.rest.builder.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import liferay.openapi.rest.builder.internal.graphql.mutation.v1_0.Mutation;
import liferay.openapi.rest.builder.internal.graphql.query.v1_0.Query;
import liferay.openapi.rest.builder.resource.v1_0.SampleResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author me
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setSampleResourceComponentServiceObjects(
			_sampleResourceComponentServiceObjects);

		Query.setSampleResourceComponentServiceObjects(
			_sampleResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/liferay-openapi-rest-builder-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<SampleResource>
		_sampleResourceComponentServiceObjects;

}