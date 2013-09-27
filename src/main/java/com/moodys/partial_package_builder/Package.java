package com.moodys.partial_package_builder;

import java.io.File;

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

}
