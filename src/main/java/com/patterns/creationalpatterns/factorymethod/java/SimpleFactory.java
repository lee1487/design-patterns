package com.patterns.creationalpatterns.factorymethod.java;

import com.patterns.creationalpatterns.factorymethod.after.v2.BlackShip;
import com.patterns.creationalpatterns.factorymethod.after.v2.WhiteShip;

public class SimpleFactory {

	public Object createProduct(String name) {
		if (name.equals("whiteship")) {
			return new WhiteShip();
		} else if (name.equals("blackship")) {
			return new BlackShip();
		}
		throw new IllegalArgumentException();
	}
}
