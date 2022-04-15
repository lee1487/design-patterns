package com.patterns.behavioralpatterns.state.after;

public class Client {

	public static void main(String[] args) {
		OnlineCourse onlineCourse = new OnlineCourse();
		Student student = new Student("hyeonse");
		Student keesun = new Student("keesun");
		keesun.addPrivate(onlineCourse);
		onlineCourse.addStudent(student);
		onlineCourse.changeState(new Private(onlineCourse));
		onlineCourse.addReview("hello", student);
		
		onlineCourse.addStudent(keesun);
		
		System.out.println(onlineCourse.getState());
		System.out.println(onlineCourse.getReviews());
		System.out.println(onlineCourse.getStudents());
	}
}
