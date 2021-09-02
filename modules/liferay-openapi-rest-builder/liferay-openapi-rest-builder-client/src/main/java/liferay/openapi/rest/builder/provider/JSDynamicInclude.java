/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package liferay.openapi.rest.builder.provider;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.util.StringUtil;
import liferay.openapi.rest.builder.config.LiferayAPIConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

@Component(
	configurationPid = {
		"liferay.openapi.rest.builder.config.LiferayAPIConfiguration"
	},
	immediate = true,
	service = DynamicInclude.class
)
public class JSDynamicInclude implements DynamicInclude {

	@Override
	public void include(HttpServletRequest request, HttpServletResponse response, String key) {
		try (
			PrintWriter printWriter = response.getWriter();
		){
			String url = _restConfig.defaultApi().equals("mock") ? _restConfig.apiMockUrl() : _restConfig.apiOpenUrl();

			printWriter.print(
				_TPL_JAVASCRIPT.replace("[$API_BASE$]", url)
			);

			printWriter.flush();
		} catch (Exception exception) {
			_log.error(String.format("Error when including value at js variable: [%s]", exception.getMessage()));
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register("/html/common/themes/top_js.jspf#resources");
	}

	private static String _loadTemplate(String name) {
		try (
			InputStream inputStream = JSDynamicInclude.class.getResourceAsStream("dependencies/" + name)
		) {
			return StringUtil.read(inputStream);
		} catch (Exception exception) {
			_log.error(String.format("Error when loading template: [%s]", exception.getMessage()));

			return StringPool.BLANK;
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_restConfig = ConfigurableUtil.createConfigurable(LiferayAPIConfiguration.class, properties);
	}

	static {
		_TPL_JAVASCRIPT = _loadTemplate("api.js.tpl");
	}

	private static final String _TPL_JAVASCRIPT;
	private static final Log _log = LogFactoryUtil.getLog(JSDynamicInclude.class);
	private LiferayAPIConfiguration _restConfig;
}
