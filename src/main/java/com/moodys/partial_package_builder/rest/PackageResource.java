package com.moodys.partial_package_builder.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("packages")
public class PackageResource {
	@GET
	@Produces("application/json")
	public String getPackage() {
		return "aaa";
	}
	
	@PUT
	public void createPackage(){
		
	}
}
