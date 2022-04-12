package com.patterns.structuralpatterns.bridge.after;

import com.patterns.structuralpatterns.bridge.before.Champion;

public class App {

	public static void main(String[] args) {
		Champion KDA아리 = new 아리(new KDA());
		KDA아리.skillQ();
		KDA아리.skillW();
		
		Champion poolParty아리 = new 아리(new PoolParty());
		poolParty아리.skillR();
		poolParty아리.skillW();
	}
}
