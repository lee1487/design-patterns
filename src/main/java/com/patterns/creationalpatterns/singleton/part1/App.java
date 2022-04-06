package com.patterns.creationalpatterns.singleton.part1;

public class App {

	public static void main(String[] args) {
		Settings settings = Settings.getInstance();
		System.out.println(settings == Settings.getInstance());
	}
}
