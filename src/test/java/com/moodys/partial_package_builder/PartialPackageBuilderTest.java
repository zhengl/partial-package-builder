package com.moodys.partial_package_builder;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PartialPackageBuilderTest {
	File fixtureFolder;
	File srcFolder;
	File srcFile;
	
	File destFolder;
	
	@Before
	public void before() throws Exception{
		fixtureFolder = new File("./fixture");
		fixtureFolder.mkdir();
		
		srcFolder = new File(fixtureFolder, "src");
		srcFolder.mkdir();
		
		srcFile = new File(srcFolder, "a.txt");
		srcFile.createNewFile();
		
		destFolder = new File(fixtureFolder, "dest");
	}
	
	@Test
	public void testCopyFilesToDest() {
		PartialPackageBuilder builder = new PartialPackageBuilder(srcFolder, destFolder);
		builder.addMapping("a.txt", "a.txt");
		builder.build();
		
		File destFile = new File(destFolder, "a.txt");
		assertTrue(destFile.exists());
	}
	
	@After
	public void after() throws Exception{
		FileUtils.deleteDirectory(fixtureFolder);
	}
}
