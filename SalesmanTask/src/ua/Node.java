package ua;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String name;
	
	private List<Edge> edges = new ArrayList<>();
	
	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}

	public void add(Edge edge) {
		edge.setStart(this);
		edges.add(edge);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Node [name=" + name);
		for (Edge edge : edges) {
			sb.append(" lenght to ");
			sb.append(edge.getEnd().getName());
			sb.append(" ");
			sb.append(edge.getLength());
		}
		sb.append("]");
		return sb.toString();
	}
}
