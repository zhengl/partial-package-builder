package com.moodys.partial_package_builder.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.moodys.partial_package_builder.FileSystemPackageRepository;
import com.moodys.partial_package_builder.FolderLister;
import com.moodys.partial_package_builder.PackageRepository;
import com.moodys.partial_package_builder.Package;

@Path("packages")
public class PackageResource {
	
	private PackageRepository repo = new FileSystemPackageRepository();
	
	@GET
	@Produces("application/json")
	public String getPackages() {
		JSONArray array = new JSONArray();
		for(Package pack: repo.getPackages()) {
			array.add(JSONObject.fromObject(pack.toJson()));
		}
		return array.toString();
	}
	
	@Path("{name}")
	@GET
	@Produces("application/json")
	public String getPackage(@PathParam("name") String name) {
		Package pack = repo.getPackageByName(name);
		FolderLister lister = new FolderLister(pack.getSrcFolder());
		JSONObject json = JSONObject.fromObject(pack.toJson());
		json.element("list", lister.listToJson());
		return json.toString();
	}	
	
	@POST
	public void createPackage(@QueryParam("name") String name, @QueryParam("path") String path){
		repo.addPackage(new Package(name, new File(path)));
	}
}
