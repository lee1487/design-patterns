package com.patterns.creationalpatterns.factorymethod.after.v1;

public class BlackshipFactory implements ShipFactory {

	@Override
	public Ship createShip() {
		return new BlackShip();
	}

}
