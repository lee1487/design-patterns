package com.patterns.behavioralpatterns.mediator.before;

public class Gym {

	private CleaningService cleaningService;
	
	public void clean() {
		cleaningService.clean(this);
	}
}
