package ua.prod.cons;

import java.util.Random;

public class Main {
	
	static volatile int tmp = 0;
	
	static volatile boolean run = true;
	
	static Thread thread1;
	
	static Thread thread2;

	public static void main(String[] args) {
		new Thread(()-> {
			while (run) {
				try {
					consume();
				} catch (InterruptedException e) { }
			}
		}).start();
		new Thread(()-> {
			for (int i = 0; i < 5; i++) {
				try {
					generate();
				} catch (InterruptedException e) { }
				if(i==4) {
					run = false;
				}
			}
		}).start();
	}

	static synchronized void generate() throws InterruptedException {
		tmp = new Random().nextInt(5)+1;
		if(thread2!=null)
		thread2.notify();
		thread1 = Thread.currentThread();
		thread1.wait();
	}
	
	static synchronized void consume() throws InterruptedException {
		System.out.println(tmp);
		if(thread1!=null)
		thread1.notify();
		thread2 = Thread.currentThread();
		thread2.wait();
	}
}
