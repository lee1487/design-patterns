package com.patterns.behavioralpatterns.visitor.after;

public interface Device {

	void print(Circle circle);
	void print(Rectangle rectangle);
	void print(Triangle triangle);

}
