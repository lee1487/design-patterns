package com.patterns.creationalpatterns.abstractfactory.after;

import com.patterns.creationalpatterns.abstractfactory.before.WhiteAnchor;
import com.patterns.creationalpatterns.abstractfactory.before.WhiteWheel;

public class WhiteshipPartsFactory implements ShipPartsFactory{

	@Override
	public Anchor createAnchor() {
		return new WhiteAnchor();
	}

	@Override
	public Wheel createWheel() {
		return new WhiteWheel();
	}

}
