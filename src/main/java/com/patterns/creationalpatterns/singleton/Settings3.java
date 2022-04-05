package com.patterns.creationalpatterns.singleton;

public class Settings3 {

	private static final Settings3 INSTANCE = new Settings3();

	private Settings3() {}

	public static Settings3 getInstance() {
		return INSTANCE;
	}
}
