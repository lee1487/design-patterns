package com.patterns.creationalpatterns.factorymethod.before;

public class Client {

	public static void main(String[] args) {
		Ship whiteShip = ShipFactory.orderShip("Whiteship", "hs.lee@naver.com");
		System.out.println(whiteShip);

		Ship blackShip = ShipFactory.orderShip("BlackShip", "hs.lee@naver.com");
		System.out.println(blackShip);
	}
}
