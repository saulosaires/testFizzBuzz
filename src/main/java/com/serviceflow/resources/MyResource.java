package com.serviceflow.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.serviceflow.service.FizzBuzzServiceImpl;
import com.serviceflow.service.IFizzBuzzService;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("fizzbuzz")
public class MyResource {
 

	private IFizzBuzzService fizzBuzzService;

	public MyResource(){
		this.fizzBuzzService=new FizzBuzzServiceImpl();
	}
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getfizzBuzzNumber(@PathParam(value = "number") Integer number) {
        return "Hello, Heroku! "+number;
    }
}
