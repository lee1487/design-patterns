package com.patterns.behavioralpatterns.command.after;

import com.patterns.behavioralpatterns.command.before.Light;

public class LightOffCommand implements Command{

	private Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

}
