package com.patterns.structuralpatterns.flyweight.java;

public class FlyweightInJava {
	
	public static void main(String[] args) {
		Integer i1 = Integer.valueOf(100000);
		Integer i2 = Integer.valueOf(100000);

//		System.out.println(i1.equals(i2));
		System.out.println(i1 == i2);
	}
}
