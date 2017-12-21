package ua.feature;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	static ExecutorService service = Executors.newWorkStealingPool();

	public static final Object[] LOCK = { new Object(), new Object() };

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		List<Integer> list = new ArrayList<>();
//		Set<Integer> set = new HashSet<>();
//		while (true) {
//			service.execute(() -> {
//				System.out.println(Thread.currentThread().getName());
//				add(list, new Random(10).nextInt());
//			});
//			service.execute(() -> {
//				System.out.println(Thread.currentThread().getName());
//				remove(list, new Random(10).nextInt());
//			});
//			service.execute(() -> {
//				System.out.println(Thread.currentThread().getName());
//				add(set, new Random(10).nextInt());
//			});
//			service.execute(() -> {
//				System.out.println(Thread.currentThread().getName());
//				remove(set, new Random(10).nextInt());
//			});
//		}
		Future<String> future = service.submit(()->{
			Thread.sleep(500);
			return "Hello";
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		List<Worker> workers = Arrays.asList(new Worker(), new Worker(), new Worker());
		String string = workers.parallelStream().map(Worker::get).findAny().get();
		System.out.println(string);
		System.out.println("-------------------------------");
		System.out.println(CompletableFuture.anyOf(
				CompletableFuture.supplyAsync(()->new Worker().get()),
				CompletableFuture.supplyAsync(()->new Worker().get()),
				CompletableFuture.supplyAsync(()->new Worker().get())).get());
		
		service.shutdown();
	}

	static void remove(List<Integer> list, int removable) {
		synchronized (LOCK[0]) {
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
			list.add(addable);
		}
	}

	static void remove(Set<Integer> list, int removable) {
		synchronized (LOCK[1]) {
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
			list.add(addable);
		}
	}
}