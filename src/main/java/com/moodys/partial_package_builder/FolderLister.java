package com.moodys.partial_package_builder;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

public class FolderLister {
	private File srcFolder;

	public FolderLister(File srcFolder) {
		this.srcFolder = srcFolder;
	}

	public String listToJson() {
		JSONArray array = new JSONArray();
		listToJson(srcFolder, array);
		return array.toString();
	}

	private void listToJson(File file, JSONArray array) {
		for (File child : file.listFiles()) {
			JSONObject bean = new JSONObject();
			bean.element("name", child.getName());
			if (child.isDirectory()) {
				JSONArray childrenArray = new JSONArray();
				listToJson(child, childrenArray);
				bean.element("children", childrenArray);
			}
			try {
				setMd5(child, bean);
			} catch (Exception e) {
				throw new RuntimeException();
			}
			array.add(bean);
		}
	}

	private void setMd5(File target, JSONObject bean) throws Exception{
		if (target.isFile()) {
			InputStream in = FileUtils.openInputStream(target);
			bean.element("md5", DigestUtils.md5Hex(in));
			in.close();
		} else if (target.isDirectory()) {
			List children = (List) PropertyUtils.getProperty(bean, "children");
			StringBuffer buffer = new StringBuffer();
			for(Object child : children) {
				buffer.append((String) PropertyUtils.getProperty(child, "md5"));
			}
			bean.element("md5", DigestUtils.md5Hex(buffer.toString()));
		}
	}

}
