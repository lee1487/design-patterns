package com.patterns.creationalpatterns.abstractfactory.before;

import com.patterns.creationalpatterns.factorymethod.after.v2.DefaultShipFactory;
import com.patterns.creationalpatterns.factorymethod.after.v2.Ship;
import com.patterns.creationalpatterns.factorymethod.after.v2.WhiteShip;

public class WhiteshipFactory extends DefaultShipFactory {

	@Override
	public Ship createShip() {
		Ship ship = new WhiteShip();
		ship.setAnchor(new WhiteAnchor());
		ship.setWheel(new WhiteWheel());
		
		return ship;
	}

}
