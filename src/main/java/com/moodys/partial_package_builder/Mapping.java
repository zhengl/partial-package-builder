package com.moodys.partial_package_builder;

import java.io.File;

public class Mapping {
	private String src;
	private String dest;
	
	public Mapping(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	public String getSrc() {
		return src;
	}
	
	public String getDest() {
		return dest;
	}
}
