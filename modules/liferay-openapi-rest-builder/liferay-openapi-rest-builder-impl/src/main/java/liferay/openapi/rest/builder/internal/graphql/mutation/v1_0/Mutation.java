package liferay.openapi.rest.builder.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import liferay.openapi.rest.builder.dto.v1_0.Sample;
import liferay.openapi.rest.builder.resource.v1_0.SampleResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setSampleResourceComponentServiceObjects(
		ComponentServiceObjects<SampleResource>
			sampleResourceComponentServiceObjects) {

		_sampleResourceComponentServiceObjects =
			sampleResourceComponentServiceObjects;
	}

	@GraphQLField
	public Sample createSample(@GraphQLName("sample") Sample sample)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> sampleResource.createSample(sample));
	}

	@GraphQLField
	public boolean deleteSample(@GraphQLName("sampleId") String sampleId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> sampleResource.deleteSample(sampleId));

		return true;
	}

	@GraphQLField
	public Response deleteSampleBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> sampleResource.deleteSampleBatch(
				callbackURL, object));
	}

	@GraphQLField
	public Sample updateSample(
			@GraphQLName("sampleId") String sampleId,
			@GraphQLName("sample") Sample sample)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> sampleResource.putSample(sampleId, sample));
	}

	@GraphQLField
	public Response updateSampleBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> sampleResource.putSampleBatch(
				callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(SampleResource sampleResource)
		throws Exception {

		sampleResource.setContextAcceptLanguage(_acceptLanguage);
		sampleResource.setContextCompany(_company);
		sampleResource.setContextHttpServletRequest(_httpServletRequest);
		sampleResource.setContextHttpServletResponse(_httpServletResponse);
		sampleResource.setContextUriInfo(_uriInfo);
		sampleResource.setContextUser(_user);
		sampleResource.setGroupLocalService(_groupLocalService);
		sampleResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<SampleResource>
		_sampleResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}