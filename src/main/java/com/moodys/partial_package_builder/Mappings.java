package com.moodys.partial_package_builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Mappings {
	private List<Mapping> mappings = new ArrayList<Mapping>();
	
	public void addMapping(String src, String dest) {
		mappings.add(new Mapping(src, dest));
	}
	
	public List<Mapping> toList(){
		return mappings;
	}
	
	public void writeToFileAsJson(File file) throws IOException{
		file.createNewFile();
		
		JSONArray array = new JSONArray();
		for (Mapping mapping : mappings) {
			JSONObject entry = new JSONObject();
			entry.element("src", mapping.getSrc());
			entry.element("dest", mapping.getDest());
			array.add(entry);
		}

		FileUtils.writeStringToFile(file, array.toString());
	}
}
