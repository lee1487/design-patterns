package com.patterns.behavioralpatterns.command.after;

import java.util.Stack;

import com.patterns.behavioralpatterns.command.before.Game;
import com.patterns.behavioralpatterns.command.before.Light;

public class Button {

	private Stack<Command> commands = new Stack<>();

	
	public void press(Command command) {
		command.execute();
		commands.push(command);
	}
	
	public void undo() {
		if (!commands.isEmpty()) {
			Command command = commands.pop();
			command.undo();
		}
	}
	
	public static void main(String[] args) {
		Button button = new Button();
		button.press(new GameStartCommand(new Game()));
		button.press(new LightOnCommand(new Light()));
		button.undo();
		button.undo();
	}
	
	
}
