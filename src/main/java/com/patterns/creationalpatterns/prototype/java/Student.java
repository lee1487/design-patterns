package com.patterns.creationalpatterns.prototype.java;

public class Student {
	
	String name;

	public Student(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
}
