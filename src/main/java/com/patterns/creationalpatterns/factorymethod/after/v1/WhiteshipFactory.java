package com.patterns.creationalpatterns.factorymethod.after.v1;

public class WhiteshipFactory implements ShipFactory {

	@Override
	public Ship createShip() {
		return new WhiteShip();
	}

}
