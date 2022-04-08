package com.patterns.creationalpatterns.factorymethod.after.v1;

public class Client {

	public static void main(String[] args) {
		Ship whiteShip = new WhiteshipFactory().orderShip("Whiteship", "hs.lee@naver.com");
		System.out.println(whiteShip);

		Ship blackShip = new BlackshipFactory().orderShip("BlackShip", "hs.lee@naver.com");
		System.out.println(blackShip);
	}
}
