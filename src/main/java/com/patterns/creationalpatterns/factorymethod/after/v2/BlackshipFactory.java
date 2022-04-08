package com.patterns.creationalpatterns.factorymethod.after.v2;

public class BlackshipFactory extends DefaultShipFactory {

	@Override
	public Ship createShip() {
		return new BlackShip();
	}

}
