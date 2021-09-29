package com.liferay.sample.module.service.filters;

import com.liferay.portal.kernel.security.access.control.AccessControlUtil;
import com.liferay.portal.kernel.security.auth.AccessControlContext;
import com.liferay.portal.kernel.security.auth.verifier.AuthVerifierResult;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.service.access.policy.ServiceAccessPolicy;
import com.liferay.sample.module.service.config.SyncSAPEntryActivator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	property = { 
		"servlet-context-name=", 
		"servlet-filter-name=Sync Auth Filter",
		"url-pattern=*" 
	}, 
	service = Filter.class
)
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

		if ((permissionChecker != null) && permissionChecker.isSignedIn()) {
			AccessControlContext accessControlContext = AccessControlUtil.getAccessControlContext();

			AuthVerifierResult authVerifierResult = accessControlContext.getAuthVerifierResult();

			if (authVerifierResult != null) {
				Map<String, Object> settings = authVerifierResult.getSettings();

				List<String> serviceAccessPolicyNames = (List<String>) settings
						.computeIfAbsent(ServiceAccessPolicy.SERVICE_ACCESS_POLICY_NAMES, value -> new ArrayList<>());

				serviceAccessPolicyNames.add(String.valueOf(SyncSAPEntryActivator.SAP_ENTRY_OBJECT_ARRAYS[1][0]));
			}
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

}