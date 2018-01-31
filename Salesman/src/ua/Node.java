package ua;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name;
	
	private List<Edge> edges = new ArrayList<>();

	public Node(String name) {
		this.name = name;
	}
	
	public void add(Edge edge) {
		edge.setStart(this);
		edges.add(edge);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
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
		StringBuilder sb = new StringBuilder();
		sb.append("Node [name=");
		sb.append(name);
		for (Edge edge : edges) {
			sb.append(" to "+edge.getEnd().name);
			sb.append(" distance ");
			sb.append(edge.getLength());
		}
		sb.append(']');
		return sb.toString();
	}
	
}
