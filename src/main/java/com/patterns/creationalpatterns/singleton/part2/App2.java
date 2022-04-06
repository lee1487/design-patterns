package com.patterns.creationalpatterns.singleton.part2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;


public class App2 {

	public static void main(String[] args) throws Exception {
		Settings settings = Settings.getInstance();
		Settings settings1 = null;
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
			out.writeObject(settings);
		}

		try (ObjectInput input = new ObjectInputStream(new FileInputStream("settings.obj"))) {
			settings1 = (Settings) input.readObject();
		}

		System.out.println(settings == settings1);

	}

}
