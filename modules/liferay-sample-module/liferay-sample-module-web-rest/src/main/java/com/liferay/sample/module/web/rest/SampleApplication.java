package com.liferay.sample.module.web.rest;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.sample.module.model.SampleObject;
import com.liferay.sample.module.service.SampleService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	
	List<SampleObject> samples = new ArrayList<SampleObject>();	

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @Path("/samples")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSamples(@Context HttpServletRequest request) {      	

//        List<SampleObject> samples = _sampleService.getSamples();
    	
    	// Mocking Data    	
    	SampleObject sampleObj1 = new SampleObject();
    	sampleObj1.setId("1");
    	sampleObj1.setName("external data 1");
    	
    	SampleObject sampleObj2 = new SampleObject();
    	sampleObj2.setId("2");
    	sampleObj2.setName("external data 2");
    	
    	SampleObject sampleObj3 = new SampleObject();
    	sampleObj3.setId("3");
    	sampleObj3.setName("external data 3");
       
    	samples.add(sampleObj1);
    	samples.add(sampleObj2);
    	samples.add(sampleObj3);
        
        return Response.ok(JSONFactoryUtil.looseSerialize(samples)).build();  
        
    }
       
    @Path("/sample/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSample(@Context HttpServletRequest request) {
    	
    	// External Service Data
//      SampleObject sample = _sampleService.addSample(sample);
    	
    	// Mocking Data    	
    	SampleObject sample = new SampleObject();
    	sample.setId("4");
    	sample.setName("external data 4");
    	
    	samples.add(sample);

        return Response.ok(JSONFactoryUtil.looseSerialize(sample)).build();
    }

    @Reference
    private SampleService _sampleService;

}
