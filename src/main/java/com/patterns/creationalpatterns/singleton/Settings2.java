package com.patterns.creationalpatterns.singleton;

public class Settings2 {

	private static Settings2 instance;

	private Settings2() {}

	public static synchronized Settings2 getInstance() {
		if (instance == null) {
			instance = new Settings2();
		}

		return instance;
	}
}
