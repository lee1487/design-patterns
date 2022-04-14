package com.patterns.behavioralpatterns.command.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.patterns.behavioralpatterns.command.before.Game;
import com.patterns.behavioralpatterns.command.before.Light;

public class CommandInJava {

	public static void main(String[] args) {
		Light light = new Light();
		Game game = new Game();
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.submit(light::on);
		executorService.submit(game::start);
		executorService.submit(game::end);
		executorService.submit(light::off);
		executorService.shutdown();
	}
}
