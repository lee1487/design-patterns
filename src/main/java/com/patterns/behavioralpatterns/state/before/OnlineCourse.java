package com.patterns.behavioralpatterns.state.before;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {

	public enum State {
		DRAFT, PUBLISHED, PRIVATE
	}
	
	private State state = State.DRAFT;
	
	private List<String> reviews = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	
	public void addReview(String review, Student student) {
		
	}
	
	public void addStudent(Student student) {}
	
	public void changeState(State newState) {
		this.state = newState;
	}
	
	public State getState() {
		return state;
	}
	
	public List<String> getReviews() {
		return reviews;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	private boolean availableTo(Student student) {
		return student.isEnabledForPrivateClass(this);
	} 
}

