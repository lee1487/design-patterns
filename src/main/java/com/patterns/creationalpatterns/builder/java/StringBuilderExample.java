package com.patterns.creationalpatterns.builder.java;

public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		String result = stringBuilder.append("whiteship ").append("keesun").toString();
		System.out.println(result);
	}
}
