package com.patterns.creationalpatterns.abstractfactory.java;

import org.springframework.beans.factory.FactoryBean;

import com.patterns.creationalpatterns.factorymethod.after.v2.Ship;
import com.patterns.creationalpatterns.factorymethod.after.v2.WhiteShip;

public class ShipFactory implements FactoryBean<Ship>{

	@Override
	public Ship getObject() throws Exception {
		Ship ship = new WhiteShip();
		ship.setName("whiteship");
		return ship;
	}

	@Override
	public Class<?> getObjectType() {
		return Ship.class;
	}

}
