package com.patterns.behavioralpatterns.mediator.after;

import java.time.LocalDateTime;

public class Guest {
	
	private Integer id;

	private FrontDesk frontDesk = new FrontDesk();
	
	public void getTower(int numberOfTowers) {
		this.frontDesk.getTowers(this,numberOfTowers);
	}
	
	public void dinner(LocalDateTime dateTime) {
		this.frontDesk.dinner(this, dateTime);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
