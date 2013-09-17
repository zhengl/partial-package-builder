package com.moodys.partial_package_builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class PartialPackageBuilder {
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private File srcFolder;
	private File destFolder;

	public PartialPackageBuilder(String src, String dest) {
	}

	public PartialPackageBuilder(File srcFolder, File destFolder) {
		this.srcFolder = srcFolder;
		this.destFolder = destFolder;
	}

	public void addMapping(String src, String dest) {
		mappings.add(new Mapping(src, dest));
	}

	public void build() {
		for (Mapping mapping : this.mappings) {
			File srcFile = new File(this.srcFolder, mapping.getSrc());
			File destFile = new File(this.destFolder, mapping.getDest());
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

}
