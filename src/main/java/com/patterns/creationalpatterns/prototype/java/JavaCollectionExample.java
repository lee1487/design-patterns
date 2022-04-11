package com.patterns.creationalpatterns.prototype.java;

import java.util.ArrayList;
import java.util.List;

public class JavaCollectionExample {

	public static void main(String[] args) {
		Student keesun = new Student("keesun");
		Student hyeonse = new Student("hyeonse");
		List<Student> students = new ArrayList<>();
		students.add(keesun);
		students.add(hyeonse);
		
		List<Student> clone = new ArrayList<>(students);
		System.out.println(clone);
	}
}
