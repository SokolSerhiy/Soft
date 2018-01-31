package ua;

public class Edge {

	private Node start;
	
	private Node end;
	
	private int length;

	public Edge(Node end, int length) {
		this.end = end;
		this.length = length;
	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
