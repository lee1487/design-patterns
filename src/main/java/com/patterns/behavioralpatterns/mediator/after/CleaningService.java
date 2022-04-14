package com.patterns.behavioralpatterns.mediator.after;

public class CleaningService {
	
	private FrontDesk frontDesk = new FrontDesk();

	public void getTowers(Integer guestId, int numberOfTowers) {
		String roomNumber = this.frontDesk.getRoomNumber(guestId);
		System.out.println("provide " + numberOfTowers + " to " + roomNumber);
	}

}
