package com.patterns.creationalpatterns.singleton.part2;

import java.lang.reflect.Constructor;


public class App {

	public static void main(String[] args) throws Exception {
		Settings settings = Settings.getInstance();

		Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Settings settings1 = constructor.newInstance();
		System.out.println(settings == settings1);
	}

}
