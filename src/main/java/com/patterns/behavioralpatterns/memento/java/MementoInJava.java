package com.patterns.behavioralpatterns.memento.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.patterns.behavioralpatterns.memento.before.Game;

public class MementoInJava {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//TODO Serializable
		Game game = new Game();
		game.setBlueTeamScore(10);
		game.setRedTeamScore(20);
		
		//TODO 직렬화 
		try(FileOutputStream fileOut = new FileOutputStream("GameSave.hex");
		ObjectOutputStream out = new ObjectOutputStream(fileOut)) 
		{
			out.writeObject(game);
		}
		
		game.setBlueTeamScore(25);
		game.setRedTeamScore(15);
		
		//TODO 역직렬화
		try(FileInputStream fileIn = new FileInputStream("GameSave.hex");
			ObjectInputStream in = new ObjectInputStream(fileIn))
		{
			game = (Game) in.readObject();
			System.out.println(game.getBlueTeamScore());
			System.out.println(game.getRedTeamScore());
		}
	}
}
