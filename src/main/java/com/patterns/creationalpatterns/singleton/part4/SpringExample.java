package com.patterns.creationalpatterns.singleton.part4;

import org.aspectj.apache.bcel.classfile.InnerClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExample {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		String hello = context.getBean("hello", String.class);
		String hello2 = context.getBean("hello", String.class);
		System.out.println(hello==hello2);
	}


}
