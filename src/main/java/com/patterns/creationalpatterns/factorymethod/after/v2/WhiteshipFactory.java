package com.patterns.creationalpatterns.factorymethod.after.v2;

public class WhiteshipFactory extends DefaultShipFactory {

	@Override
	public Ship createShip() {
		return new WhiteShip();
	}

}
