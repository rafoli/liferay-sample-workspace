package com.acme.movie.fanatics.registration.web.portlet;

import com.acme.movie.fanatics.registration.web.constants.AcmeMovieFanaticsRegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alexandre de Souza Jr.
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.AMF",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AcmeMovieFanaticsRegistration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AcmeMovieFanaticsRegistrationPortletKeys.ACMEMOVIEFANATICSREGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AcmeMovieFanaticsRegistrationPortlet extends MVCPortlet {
}