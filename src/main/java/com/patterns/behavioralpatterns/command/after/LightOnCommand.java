package com.patterns.behavioralpatterns.command.after;

import com.patterns.behavioralpatterns.command.before.Light;

public class LightOnCommand implements Command {
	
	private Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}



	@Override
	public void execute() {
		light.on();
	}

}
