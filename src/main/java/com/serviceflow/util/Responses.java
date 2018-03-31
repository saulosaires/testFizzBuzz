package com.serviceflow.util;

import javax.ws.rs.core.Response;

public class Responses {

	private Responses() {
		throw new IllegalStateException("Responses Utility class");
	}
	
	public static Response badRequest(Object obj) {

		return Response.status(Response.Status.BAD_REQUEST).entity(obj).build();

	}

	public static Response ok(Object obj) {

		return Response.status(Response.Status.ACCEPTED).entity(obj).build();

	}
	
	public static Response internalServerError(Object obj) {

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(obj).build();

	}
	
}
