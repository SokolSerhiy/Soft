package ua;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes = new ArrayList<>();
	
	private List<Integer> length = new ArrayList<>();
	
	public void add(Node node, int lenght) {
		this.nodes.add(node);
		this.length.add(lenght);
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public List<Integer> getLength() {
		return length;
	}

	public void setLength(List<Integer> length) {
		this.length = length;
	}

	public int sum() {
		return length.stream().mapToInt(e->e).sum();
	}
}
