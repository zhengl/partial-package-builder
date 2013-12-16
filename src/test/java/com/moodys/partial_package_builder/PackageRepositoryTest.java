package com.moodys.partial_package_builder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PackageRepositoryTest {
	Fixture fixture;
	PackageRepository repo;

	@Before
	public void before() throws IOException {
		fixture = new Fixture();
		fixture.create();
		repo = new FileSystemPackageRepository();
	}
	
	@Test
	public void testCreatePackage(){
		Package pack = new Package("foo", fixture.srcFolder);
		repo.addPackage(pack);
		assertEquals(1, repo.getPackages().size());
		
		Package returnedPack = repo.getPackages().get(0);
		assertEquals(fixture.srcFolder.getAbsolutePath(), returnedPack.getSrcFolder().getAbsolutePath());
	}
	
	@Test
	public void testGetPackageByName(){
		Package pack = new Package("foo", fixture.srcFolder);
		repo.addPackage(pack);
		
		Package returnedPack = repo.getPackageByName("foo");
		assertEquals(fixture.srcFolder.getAbsolutePath(), returnedPack.getSrcFolder().getAbsolutePath());
	}
	
	@After
	public void after() throws Exception {
		fixture.destroy();
		FileUtils.deleteDirectory(FileSystemPackageRepository.REPO_PATH);
	}
}
