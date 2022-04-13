package com.patterns.structuralpatterns.proxy.after.v1;

import com.patterns.structuralpatterns.proxy.before.GameService;

public class GameServiceProxy extends GameService {

	@Override
	public void startGame() {
		long before = System.currentTimeMillis();
		super.startGame();
		System.out.println(System.currentTimeMillis() - before);
	}
}
