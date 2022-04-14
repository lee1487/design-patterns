package com.patterns.behavioralpatterns.mediator.after;

import java.time.LocalDateTime;

public class Restaurant {
	
	private FrontDesk frontDesk = new FrontDesk();
	
	public void dinner(Integer id, LocalDateTime dateTime) {
		String roomNumber = frontDesk.getRoomNumber(id);
		System.out.println("we'll provide dinner to  " + roomNumber + ". Reservation time is " + dateTime);
		System.out.println("Thank you!");
	}

}
