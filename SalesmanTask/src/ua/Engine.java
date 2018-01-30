package ua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {
	
	private Scanner sc = new Scanner(System.in);

	private List<Node> nodes = new ArrayList<>();
	
	public void add() {
		try {
			System.out.println("Enter city name");
			Node end = new Node(sc.next());
			nodes.forEach(start->addEdge(start, end));
			nodes.add(end);
		}catch (Exception e) { }
		nodes.forEach(System.out::println);
	}
	
	public void addEdge(Node start, Node end) {
		System.out.println("Enter distance to "+start.getName());
		int length = sc.nextInt();
		start.add(new Edge(end, length));
		System.out.println("Enter reverse distance");
		end.add(new Edge(start, sc.nextInt()));
	}

	public void result() {
		System.out.println("Enter start city name");
		String name = sc.next();
		Node node = findByName(name);
		if(node==null) {
			System.err.println("Invalid name");
		}else {
			try {
				findResult(node);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private Node findByName(String name) {
		for (Node node : nodes) {
			if(node.getName().equalsIgnoreCase(name)) return node;
		}
		return null;
	}
	
	private void findResult(Node node) {
		new Resulter(node).calculateResult();
	}
}
