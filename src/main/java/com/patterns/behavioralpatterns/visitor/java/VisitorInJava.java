package com.patterns.behavioralpatterns.visitor.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VisitorInJava {

	public static void main(String[] args) throws IOException {
		Path startingDirectory = Path.of("D:\\escrow(gtp)\\workspace\\design-patterns");
		SearchFileVisitor searchFileVisitor = new SearchFileVisitor("Triangle.java", startingDirectory);
		Files.walkFileTree(startingDirectory, searchFileVisitor);
	}
}
