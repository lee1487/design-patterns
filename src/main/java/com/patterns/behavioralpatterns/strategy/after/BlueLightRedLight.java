package com.patterns.behavioralpatterns.strategy.after;

public class BlueLightRedLight {
	
//	private Speed speed;
//	
//	public BlueLightRedLight(Speed speed) {
//		this.speed = speed;
//	}

	public void blueLight(Speed speed) {
		speed.blueLight();
	}
	
	public void redLight(Speed speed) {
		speed.redLight();
	}
}
