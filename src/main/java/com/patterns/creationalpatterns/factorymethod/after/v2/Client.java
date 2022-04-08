package com.patterns.creationalpatterns.factorymethod.after.v2;

public class Client {

	public static void main(String[] args) {
		Client client = new Client();
		client.print(new WhiteshipFactory(), "Whiteship", "hs.lee@naver.com");
		client.print(new BlackshipFactory(), "BlackShip", "hs.lee@naver.com");

	}

	private void print(ShipFactory shipFactory, String name, String email) {
		System.out.println(shipFactory.orderShip(name, email));
	}
}
