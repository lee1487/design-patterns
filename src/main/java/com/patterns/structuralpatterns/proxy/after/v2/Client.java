package com.patterns.structuralpatterns.proxy.after.v2;

public class Client {

	public static void main(String[] args) {
		GameService gameService = new GameServiceProxy();
		gameService.startGame();
	}
}
