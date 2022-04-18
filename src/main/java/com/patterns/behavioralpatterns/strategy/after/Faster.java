package com.patterns.behavioralpatterns.strategy.after;

public class Faster implements Speed{

	@Override
	public void blueLight() {
		System.out.println("무 궁화꽃이");
	}

	@Override
	public void redLight() {
		System.out.println("피었습니다.");
	}

}
