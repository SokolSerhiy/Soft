package ua.feature;

import java.util.Random;

public class Worker {

	public String get() {
		int time = new Random().nextInt(500);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) { }
		System.out.println(time);
		return "Hello"+time;
	}
}
