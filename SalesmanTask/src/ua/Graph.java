package ua;

import java.util.Arrays;

public class Graph {

	private final Node[] nodes;
	
	private final int[] length;

	public Graph(int length) {
		this.nodes = new Node[length];
		this.length = new int[length];
	}
	
	public void placeNode(int index, Node node, int length) {
		this.nodes[index] = node;
		this.length[index] = length;
	}

	public Node[] getNodes() {
		return nodes;
	}
	
	public int sum() {
		return Arrays.stream(length).sum();
	}

	public String toString(Node node) {
		StringBuilder sb = new StringBuilder();
		sb.append("From ");
		sb.append(node.getName());
		for(int i = 0; i < nodes.length; i++) {
			sb.append(" to ");
			sb.append(this.length[i]);
			sb.append(" from ");
			sb.append(nodes[i].getName());
		}
		sb.append(" result is ");
		sb.append(sum());
		return sb.toString();
	}
	
	
}
