package com.moodys.partial_package_builder;

import java.io.File;

import net.sf.json.JSONObject;

public class Package {
	private String name;
	private File srcFolder;

	public Package(String name, File srcFolder) {
		this.name = name;
		this.srcFolder = srcFolder;
	}

	public String getName() {
		return name;
	}

	public File getSrcFolder() {
		return srcFolder;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSrcFolder(File srcFolder) {
		this.srcFolder = srcFolder;
	}

	public String toJson(){
		JSONObject json = new JSONObject();
		json.element("name", this.name);
		json.element("src", this.srcFolder.getAbsolutePath());
		return json.toString();
	}
}
