package com.liferay.sample.module.web.rest;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.service.SampleService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Rafael Oliveira
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/sample-module",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=SampleModule.Rest"
        },
        service = Application.class
)
@Produces(MediaType.APPLICATION_JSON)
public class SampleApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Path("/samples")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSamples(@Context HttpServletRequest request) {
        List<SampleObject> samples = _sampleService.getSamples();

        return Response.ok(JSONFactoryUtil.looseSerialize(samples)).build();
    }

    @Reference
    private SampleService _sampleService;

}
