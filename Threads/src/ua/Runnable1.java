package ua;

public class Runnable1 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}