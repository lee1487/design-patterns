package com.patterns.behavioralpatterns.command.after;

import com.patterns.behavioralpatterns.command.before.Game;

public class GameStartCommand implements Command{

	private Game game;
	
	public GameStartCommand(Game game) {
		this.game = game;
	}


	@Override
	public void execute() {
		game.start();
	}

}
