package com.patterns.creationalpatterns.singleton.part3;

import java.lang.reflect.Constructor;


public class App {

	public static void main(String[] args) throws Exception {
		Settings settings = Settings.INSTANCE;
		Settings settings1 = null;
		Constructor<?>[] declaredConstructors = Settings.class.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			constructor.setAccessible(true);
			settings1 = (Settings) constructor.newInstance("INSTANCE");

		}
		System.out.println(settings == settings1);
	}

}
