package com.patterns.behavioralpatterns.template.after;

public class Plus extends FileProcessor {
	
	public Plus(String path) {
		super(path);
	}

	@Override
	protected int getResult(int result, int number) {
		return result += number;
	}

}
