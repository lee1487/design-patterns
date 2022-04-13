package com.patterns.structuralpatterns.proxy.before;

public class Client {
	public static void main(String[] args) {
		GameService gameService = new GameService();
		gameService.startGame();
	}
}
