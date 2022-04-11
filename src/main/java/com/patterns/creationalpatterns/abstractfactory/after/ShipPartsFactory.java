package com.patterns.creationalpatterns.abstractfactory.after;

public interface ShipPartsFactory {
	
	Anchor createAnchor();
	
	Wheel createWheel();
}
