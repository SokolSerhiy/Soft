package ua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {

	private Scanner sc;
	
	private List<Node> nodes = new ArrayList<>();

	public Engine(Scanner sc) {
		this.sc = sc;
	}
	
	public void addNode() {
		System.out.println("Enter city name");
		String name = sc.next();
		Node node = new Node(name);
		for (Node tmp : nodes) {
			System.out.println("Enter distance from "+node.getName()+" to "+tmp.getName());
			int length = sc.nextInt();
			node.add(new Edge(tmp, length));
			System.out.println("Enter distance from "+tmp.getName()+" to "+node.getName());
			length = sc.nextInt();
			tmp.add(new Edge(node, length));
		}
		nodes.add(node);
		nodes.forEach(System.out::println);
	}
	
	
	public void calculate() {
		if(nodes.isEmpty()||nodes.size()==1) {
			System.out.println("Nothing to calculate");
		}else if(nodes.size()==2) {
			System.out.println("Enter start city");
			String name = sc.next();
			for (Node node : nodes) {
				if(node.getName().equalsIgnoreCase(name)) {
					System.out.println(node);
				}
			}
		}else {
			hardWork();
		}
	}

	private void hardWork() {
		System.out.println("Enter start city");
		String name = sc.next();
		Node node = findNodeByName(name);
		if(node==null) {
			System.out.println("Could not find city with name "+name);
		}else {
			new Calculator(node).calculate();
		}
	}
	
	private Node findNodeByName(String name) {
		for (Node node : nodes) {
			if(node.getName().equalsIgnoreCase(name)) {
				return node;
			}
		}
		return null;
	}
}
