package ua.prod.cons;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Work work = new Work();
		Thread consumer = new Thread(()-> {
			while (!work.done) {
				try {
					consume(work);
				} catch (InterruptedException e) { }
			}
		});
		Thread producer = new Thread(()->{
			for(int i = 0; i < 5; i++) {
				try {
					if(i==4) work.done = true;
					produce(work);
				} catch (InterruptedException e) { }
			}
		});
		consumer.start();
		producer.start();
	}
	
	static void consume(Work work) throws InterruptedException {
		synchronized (Main.class) {
			if(work.amount==Integer.MIN_VALUE) {
				System.out.println("Consumer goes to sleep");
				Main.class.wait(100);
			}
			System.out.println(work.amount);
			Main.class.notify();
			Main.class.wait(100);
		}
	}
	
	static void produce(Work work) throws InterruptedException {
		synchronized (Main.class) {
			work.amount = new Random().nextInt(10);
			System.out.println("Producer goes to sleep");
			Main.class.notify();
			Main.class.wait(100);
		}
	}
}