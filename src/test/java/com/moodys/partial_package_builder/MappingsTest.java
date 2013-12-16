package com.moodys.partial_package_builder;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class MappingsTest {
	@Test
	public void testWriteToFile() throws IOException{
		Mappings mappings = new Mappings();
		mappings.addMapping("a.txt", "aa.txt");
		mappings.addMapping("b.txt", "bb.txt");
		
		File mappingsFile = new File("mappings.json");
		mappingsFile.deleteOnExit();
		
		mappings.writeToJsonFile(mappingsFile);
		assertTrue(mappingsFile.exists());
		
		JSONArray array = JSONArray.fromObject(FileUtils.readFileToString(mappingsFile));
		assertTrue(array.size() == 2);
	}
	
	@Test
	public void testReadFromFile() throws Exception{		
		File mappingsFile = new File("mappings.json");
		mappingsFile.deleteOnExit();
		FileUtils.writeStringToFile(mappingsFile, "[{\"src\":\"a.txt\",\"dest\":\"aa.txt\"},{\"src\":\"b.txt\",\"dest\":\"bb.txt\"}]");
		
		Mappings mappings = new Mappings();
		mappings.readFromJsonFile(mappingsFile);
		
		assertTrue(mappings.toList().size() == 2);
		assertTrue(mappings.toList().get(0).getSrc().equals("a.txt"));
	}
}
