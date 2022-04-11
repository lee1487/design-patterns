package com.patterns.creationalpatterns.builder.java;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamExample {

	public static void main(String[] args) {
//		Builder<String> stringStreamBuilder  = Stream.builder();
//		Stream<String> names = stringStreamBuilder.add("keesun").add("whiteship").build();
		
		Stream<String> names = Stream.<String>builder().add("keesun").add("whiteship").build();
		names.forEach(System.out::println);
	}
}
