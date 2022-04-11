package com.patterns.creationalpatterns.abstractfactory.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patterns.creationalpatterns.factorymethod.after.v2.Ship;

public class FactoryBeanExample {

	public static void main(String[] args) {
//      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//      Ship whiteship = applicationContext.getBean("whiteship", Ship.class);
//      System.out.println(whiteship.getName());
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
//		ShipFactory bean = applicationContext.getBean(ShipFactory.class);
		Ship bean = applicationContext.getBean(Ship.class);
		System.out.println(bean);
		
	}
}
