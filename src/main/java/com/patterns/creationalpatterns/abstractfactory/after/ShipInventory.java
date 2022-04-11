package com.patterns.creationalpatterns.abstractfactory.after;

import com.patterns.creationalpatterns.factorymethod.after.v2.Ship;
import com.patterns.creationalpatterns.factorymethod.after.v2.ShipFactory;

public class ShipInventory {

	public static void main(String[] args) {
		ShipFactory shipFactory = new WhiteshipFactory(new WhitePartsProFactory());
		Ship ship = shipFactory.createShip();
		System.out.println(ship.getAnchor().getClass());
		System.out.println(ship.getWheel().getClass());
	}
}
