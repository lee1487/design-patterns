package com.patterns.creationalpatterns.abstractfactory.after;

import com.patterns.creationalpatterns.factorymethod.after.v2.DefaultShipFactory;
import com.patterns.creationalpatterns.factorymethod.after.v2.Ship;
import com.patterns.creationalpatterns.factorymethod.after.v2.WhiteShip;

public class WhiteshipFactory extends DefaultShipFactory {

	private ShipPartsFactory shipPartsFactory;

	public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
		this.shipPartsFactory = shipPartsFactory;
	}

	@Override
	public Ship createShip() {
		Ship ship = new WhiteShip();
		ship.setAnchor(shipPartsFactory.createAnchor());
		ship.setWheel(shipPartsFactory.createWheel());

		return ship;
	}

}
