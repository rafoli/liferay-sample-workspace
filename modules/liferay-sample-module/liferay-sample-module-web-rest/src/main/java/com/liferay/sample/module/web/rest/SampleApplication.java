package com.liferay.sample.module.web.rest;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.service.SampleService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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

    @Path("/samples/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSamples(@Context HttpServletRequest request, @PathParam("id") String id) {

        SampleObject sample = _sampleService.getSample(id);

        return Response.ok(JSONFactoryUtil.looseSerialize(sample)).build();

    }

    @Path("/samples")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSample(@Context HttpServletRequest request, String body) {

    	SampleObject sample = JSONFactoryUtil.looseDeserialize(body, SampleObject.class);

        sample = _sampleService.addSample(sample);

        return Response.ok(JSONFactoryUtil.looseSerialize(sample)).build();
    }

    @Path("/samples")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSample(@Context HttpServletRequest request, String body) {

    	SampleObject sample = JSONFactoryUtil.looseDeserialize(body, SampleObject.class);
    	
        SampleObject s = _sampleService.getSample(sample.getId());

        if(s == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        else
        	sample = _sampleService.updateSample(sample);
        	return Response.ok(JSONFactoryUtil.looseSerialize(sample)).build();
        	
    }

    @Path("/samples/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSample(@Context HttpServletRequest request, String id) {

        SampleObject s = _sampleService.getSample(id);

        if(s == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        _sampleService.deleteSample(id);

        return Response.status(Response.Status.OK).build();
    }

    @Reference
    private SampleService _sampleService;

}
