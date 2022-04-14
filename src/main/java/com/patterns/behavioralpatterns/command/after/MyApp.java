package com.patterns.behavioralpatterns.command.after;

import com.patterns.behavioralpatterns.command.before.Game;

public class MyApp {

	private Command command;

	public MyApp(Command command) {
		this.command = command;
	}
	
	public void press() {
		command.execute();
	}
	
	public static void main(String[] args) {
		MyApp myApp = new MyApp(new GameStartCommand(new Game()));
		myApp.press();
	}
	
	
}
