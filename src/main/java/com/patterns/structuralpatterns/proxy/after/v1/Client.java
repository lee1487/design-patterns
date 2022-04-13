package com.patterns.structuralpatterns.proxy.after.v1;

import com.patterns.structuralpatterns.proxy.before.GameService;

public class Client {
	public static void main(String[] args) {
		GameService gameService = new GameServiceProxy();
		gameService.startGame();
	}
}
