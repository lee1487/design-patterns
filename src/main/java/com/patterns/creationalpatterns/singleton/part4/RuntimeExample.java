package com.patterns.creationalpatterns.singleton.part4;

public class RuntimeExample {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.maxMemory());
		System.out.println(runtime.freeMemory());
	}

}
