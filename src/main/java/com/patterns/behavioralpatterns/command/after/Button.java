package com.patterns.behavioralpatterns.command.after;

import com.patterns.behavioralpatterns.command.before.Game;
import com.patterns.behavioralpatterns.command.before.Light;

public class Button {

	private Command command;

	public Button(Command command) {
		this.command = command;
	}
	
	public void press() {
		command.execute();
	}
	
	public static void main(String[] args) {
		Button button = new Button(new GameStartCommand(new Game()));
		
		button.press();
		button.press();
	}
	
	
}
