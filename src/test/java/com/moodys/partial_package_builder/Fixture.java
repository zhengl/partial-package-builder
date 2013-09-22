package com.moodys.partial_package_builder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Fixture {
	File fixtureFolder;
	File srcFolder;
	File srcFile;
	File subSrcFolder;
	File subSrcFile;

	File destFolder;

	public void create() throws IOException {
		fixtureFolder = new File("./fixture");
		fixtureFolder.mkdir();

		srcFolder = new File(fixtureFolder, "src");
		srcFolder.mkdir();

		srcFile = new File(srcFolder, "a.txt");
		srcFile.createNewFile();

		subSrcFolder = new File(srcFolder, "sub");
		subSrcFolder.mkdir();

		subSrcFile = new File(subSrcFolder, "b.txt");
		subSrcFile.createNewFile();

		destFolder = new File(fixtureFolder, "dest");
	}

	public void destroy() throws IOException {
		FileUtils.deleteDirectory(fixtureFolder);
	}

}
