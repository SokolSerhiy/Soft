package ua;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

	public static final Object[] LOCK = { new Object(), new Object() };
	
	static volatile int count = 0;
	
	static volatile int count1 = count;

	public static void main(String[] args) throws InterruptedException {
		// new Thread1().start();
		// new Thread(()->System.out.println(Thread.currentThread().getName())).start();
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		new Thread(() -> {
			while (true) {
				add(list, new Random(10).nextInt());
			}
		}).start();
		new Thread(() -> {
			while (true) {
				remove(list, new Random(10).nextInt());
			}
		}).start();
		new Thread(() -> {
			while (true) {
				add(set, new Random(10).nextInt());
			}
		}).start();
		Thread thread = new Thread(() -> {
			while (true) {
				remove(set, new Random(10).nextInt());
			}
		});
		thread.start();
		thread.join();
		System.out.println(Thread.currentThread().getName());
	}

	static void remove(List<Integer> list, int removable) {
		synchronized (LOCK[0]) {
			System.out.println(++count);
			Iterator<Integer> liIterator = list.iterator();
			while (liIterator.hasNext()) {
				if (liIterator.next() == removable) {
					liIterator.remove();
				}
			}
		}
	}

	static void add(List<Integer> list, int addable) {
		synchronized (LOCK[0]) {
			System.out.println(++count);
			list.add(addable);
		}
	}

	static void remove(Set<Integer> list, int removable) {
		synchronized (LOCK[1]) {
			System.out.println(++count);
			Iterator<Integer> liIterator = list.iterator();
			while (liIterator.hasNext()) {
				if (liIterator.next() == removable) {
					liIterator.remove();
				}
			}
		}
	}

	static void add(Set<Integer> list, int addable) {
		synchronized (LOCK[1]) {
			System.out.println(++count);
			list.add(addable);
		}
	}
}