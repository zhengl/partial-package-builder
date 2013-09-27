package com.moodys.partial_package_builder;

import java.util.List;

public interface PackageRepository {

	void addPackage(Package pack);

	List<Package> getPackages();

}
