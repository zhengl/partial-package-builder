package com.moodys.partial_package_builder;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PartialPackageBuilderTest {
	Fixture fixture = new Fixture();
	PartialPackageBuilder builder;
	
	@Before
	public void before() throws Exception{
		fixture.create();
		builder = new PartialPackageBuilder(fixture.srcFolder, fixture.destFolder);
	}
	
	@Test
	public void testCopySrcFileToDestFile() {
		builder.getMappings().addMapping("a.txt", "a.txt");
		builder.build();
		
		File destFile = new File(fixture.destFolder, "a.txt");
		assertTrue(destFile.exists());
	}
	
	@Test
	public void testCopySrcFolderToDestFolder() {
		builder.getMappings().addMapping("sub", ".");
		builder.build();
		
		File destSubFolder = new File(fixture.destFolder, "sub");
		assertTrue(destSubFolder.exists());
	}
	
	@Test
	public void testCopySrcFolderToDeepDestFolder() {
		builder.getMappings().addMapping("sub", "deep/deep/sub");
		builder.build();
		
		File destSubFolder = new File(fixture.destFolder, "deep/deep/sub");
		assertTrue(destSubFolder.exists());
	}		
	
	@Test
	public void testCopySrcFileToDestFolder() {
		builder.getMappings().addMapping("a.txt", ".");
		builder.build();
		
		File destFile = new File(fixture.destFolder, "a.txt");
		assertTrue(destFile.exists());
	}	
		
	
	@After
	public void after() throws Exception{
		fixture.destroy();
	}
}
