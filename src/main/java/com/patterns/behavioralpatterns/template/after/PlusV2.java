package com.patterns.behavioralpatterns.template.after;

public class PlusV2 implements Operator{

	@Override
	public int getResult(int result, int number) {
		return result += number;
	}

}
