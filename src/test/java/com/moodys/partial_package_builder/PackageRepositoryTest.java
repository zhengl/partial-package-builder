package com.moodys.partial_package_builder;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PackageRepositoryTest {
	Fixture fixture;

	@Before
	public void before() throws IOException {
		fixture = new Fixture();
		fixture.create();
	}
	
	@Test
	public void testCreatePackage(){
		PackageRepository repo = new FileSystemPackageRepository();
		Package pack = new Package("foo", fixture.srcFolder);
		repo.addPackage(pack);
		assertEquals(1, repo.getPackages().size());
		
		Package returnedPack = repo.getPackages().get(0);
		assertEquals(fixture.srcFolder.getAbsolutePath(), returnedPack.getSrcFolder().getAbsolutePath());
	}
	
	@After
	public void after() throws Exception {
		fixture.destroy();
	}
}
