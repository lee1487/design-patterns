package com.patterns.behavioralpatterns.strategy.java;

import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class StrategyInSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext();
		ApplicationContext context1 = new FileSystemXmlApplicationContext();
		ApplicationContext context2 = new AnnotationConfigApplicationContext();
		
		BeanDefinitionParser parser;
		
		PlatformTransactionManager platformTransactionManager;
		
		CacheManager cacheManager;
	}
}
