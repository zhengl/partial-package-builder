package com.moodys.partial_package_builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class PartialPackageBuilder {
	private Mappings mappings = new Mappings();
	private File srcFolder;
	private File destFolder;

	public PartialPackageBuilder(String src, String dest) {
	}

	public PartialPackageBuilder(File srcFolder, File destFolder) {
		this.srcFolder = srcFolder;
		this.destFolder = destFolder;
	}

	public void build() {
		for (Mapping mapping : mappings.toList()) {
			File src = new File(this.srcFolder, mapping.getSrc());
			File dest = new File(this.destFolder, mapping.getDest());
			try {
				if (isFolderByName(mapping.getSrc()) && isFolderByName(mapping.getDest())){
					FileUtils.copyDirectoryToDirectory(src, dest);
				} else if (!isFolderByName(mapping.getSrc()) && isFolderByName(mapping.getDest())){
					FileUtils.copyFileToDirectory(src, dest);					
				} else if (!isFolderByName(mapping.getSrc()) && !isFolderByName(mapping.getDest())){
					FileUtils.copyFile(src, dest);
				}
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

	private boolean isFolderByName(String name) {
		return name.equals(".") || name.equals("..") || !name.contains(".");
	}
	
	public Mappings getMappings() {
		return mappings;
	}

}
