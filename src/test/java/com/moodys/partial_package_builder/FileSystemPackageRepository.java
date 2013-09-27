package com.moodys.partial_package_builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileSystemPackageRepository implements PackageRepository {

	private static File REPO_PATH = new File("repo");
	private static String SRC_CONFIG_FILENAME = "src.config";

	public void addPackage(Package pack) {
		if (!REPO_PATH.exists()) {
			REPO_PATH.mkdir();
		}

		File packInRepo = new File(REPO_PATH, pack.getName());
		packInRepo.mkdir();
		
		File srcConfig = new File(packInRepo, SRC_CONFIG_FILENAME);
		try {
			FileUtils.writeStringToFile(srcConfig, pack.getSrcFolder().getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	public List<Package> getPackages() {
		List<Package> packs = new ArrayList<Package>();
		File[] packFolders = REPO_PATH.listFiles();
		for(File packFolder: packFolders){
			File srcConfig = new File(packFolder, SRC_CONFIG_FILENAME);
			String src;
			try {
				src = FileUtils.readFileToString(srcConfig);
			} catch (IOException e) {
				throw new RuntimeException();
			}
			packs.add(new Package(packFolder.getName(), new File(src)));
		}
		
		return packs;
	}

}
