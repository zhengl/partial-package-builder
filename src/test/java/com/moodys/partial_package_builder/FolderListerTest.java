package com.moodys.partial_package_builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FolderListerTest {
	Fixture fixture;
	FolderLister lister;

	@Before
	public void before() throws IOException {
		fixture = new Fixture();
		fixture.create();
		lister = new FolderLister(fixture.fixtureFolder);
	}

	@Test
	public void testListToJson() throws Exception {
		String jsonStr = lister.listToJson();
		JSONArray json = JSONArray.fromObject(jsonStr);
		assertEquals(1, json.size());
		
		Object bean = json.get(0);
		assertTrue(((String) PropertyUtils.getProperty(bean, "name")).contains("src"));
		List children = (List) PropertyUtils.getProperty(bean, "children");
		assertEquals(2, children.size());
	}
	
	@Test
	public void testMd5() throws Exception {
		String previousJsonStr = lister.listToJson();
		JSONArray previousJson = JSONArray.fromObject(previousJsonStr);
		Object previousBean = previousJson.get(0);
		String previousMd5 = (String) PropertyUtils.getProperty(previousBean, "md5");
		assertNotNull(previousMd5);
		
		FileUtils.writeStringToFile(fixture.srcFile, "some new content");
		String currentJsonStr = lister.listToJson();
		JSONArray currentJson = JSONArray.fromObject(currentJsonStr);
		Object currentBean = currentJson.get(0);
		String currentMd5 = (String) PropertyUtils.getProperty(currentBean, "md5");
		assertFalse(previousMd5.equals(currentMd5));
	}	

	@After
	public void after() throws Exception {
		fixture.destroy();
	}

}
