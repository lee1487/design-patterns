package com.patterns.creationalpatterns.singleton.part1;

public class Settings5 {

	private Settings5() {}

	private static class SettingsHolder {
		private static final Settings5 INSTANCE = new Settings5();
	}

	public static Settings5 getInstance() {
		return SettingsHolder.INSTANCE;
	}
}
