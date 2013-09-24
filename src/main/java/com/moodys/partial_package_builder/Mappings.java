package com.moodys.partial_package_builder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Mappings {
	private List<Mapping> mappings = new ArrayList<Mapping>();

	public void addMapping(String src, String dest) {
		mappings.add(new Mapping(src, dest));
	}

	public List<Mapping> toList() {
		return mappings;
	}

	public void writeToJsonFile(File file) throws IOException {
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

	public void readFromJsonFile(File file) throws Exception {
		JSONArray array = JSONArray
				.fromObject(FileUtils.readFileToString(file));
		for (Object entry : array.toArray()) {
			String src = (String) PropertyUtils.getProperty(entry, "src");
			String dest = (String) PropertyUtils.getProperty(entry, "dest");
			this.mappings.add(new Mapping(src, dest));
		}
	}

}
