package liferay.openapi.rest.builder.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import liferay.openapi.rest.builder.dto.v1_0.Sample;
import liferay.openapi.rest.builder.resource.v1_0.SampleResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Query {

	public static void setSampleResourceComponentServiceObjects(
		ComponentServiceObjects<SampleResource>
			sampleResourceComponentServiceObjects) {

		_sampleResourceComponentServiceObjects =
			sampleResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allSamples(pageNumber: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public SamplePage allSamples(
			@GraphQLName("pageNumber") Integer pageNumber,
			@GraphQLName("pageSize") Integer pageSize)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> new SamplePage(
				sampleResource.getAllSamples(pageNumber, pageSize)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {sample(sampleId: ___){name, id}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Sample sample(@GraphQLName("sampleId") String sampleId)
		throws Exception {

		return _applyComponentServiceObjects(
			_sampleResourceComponentServiceObjects,
			this::_populateResourceContext,
			sampleResource -> sampleResource.getSample(sampleId));
	}

	@GraphQLName("SamplePage")
	public class SamplePage {

		public SamplePage(Page samplePage) {
			actions = samplePage.getActions();

			items = samplePage.getItems();
			lastPage = samplePage.getLastPage();
			page = samplePage.getPage();
			pageSize = samplePage.getPageSize();
			totalCount = samplePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Sample> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}