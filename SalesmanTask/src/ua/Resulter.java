package ua;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Resulter {

	private final Node node;
	
	private final List<Node> nodes;
	
	private final List<Graph> graphes = new ArrayList<>();
	
	private final int graphesCount;
	
	private final int onePositionCount;
	
	private final Map<Integer, List<Node>> usedByPosition = new HashMap<>();

	public Resulter(Node node) {
		this.node = node;
		this.nodes = node.getEdges().stream().map(Edge::getEnd).collect(Collectors.toList());
		graphesCount = factorial(nodes.size());
		onePositionCount = factorial(nodes.size()-1);
	}
	
	public void calculateResult() {
		if (nodes.isEmpty()) {
			System.out.println("Nothing to show, there is only one city "+node.getName());
		} else if(nodes.size()==1) {
			System.out.println("Simple task result is "+node.getEdges().get(0).getLength()+" from "+node.getName()
			+" to "+node.getEdges().get(0).getEnd().getName());
		} else {
			hardWork();
		}
	}
	
	private void hardWork() {
		for(int i = 0; i < graphesCount; i++) {
			Graph graph = new Graph(nodes.size());
			for(int j = 0; j < nodes.size(); j++) {
				Node node = this.node.getEdges().get((int)(Math.random()*this.node.getEdges().size())).getEnd();
				Node start = j == 0 ? this.node : graph.getNodes()[j-1];
				if(!node.equals(start)&&!isUsedInGraph(graph, node)&&!isUsedByPosition(node, j)) {
					graph.placeNode(j, node, findLength(start, node));
				}else {
					j--;
				}
			}
			graphes.add(graph);
		}
		graphes.sort(Comparator.comparing(Graph::sum));
		graphes.forEach(g->System.out.println(g.toString(node)));
	}
	
	private boolean isUsedByPosition(Node node, int position) {
		List<Node> nodes = usedByPosition.get(position);
		int usedCount = usedCount(nodes, node);
		if(usedCount==onePositionCount) return true;
		if(nodes==null) {
			nodes = new ArrayList<>();
		}
		nodes.add(node);
		usedByPosition.put(position, nodes);
		return false;
	}
	
	private int usedCount(List<Node> nodes, Node node) {
		if(nodes==null)return 0;
		return (int) nodes.stream().filter(tmp->tmp.equals(node)).count();
	}
	
	private boolean isUsedInGraph(Graph graph, Node node) {
		int i = 0;
		Node tmp = graph.getNodes()[i];
		while(tmp != null && i < graph.getNodes().length) {
			if(node.equals(tmp)) return true;
			i++;
		}
		return false;
	}
	
	private int findLength(Node start, Node end) {
		for (Edge edge : start.getEdges()) {
			if(edge.getEnd().equals(end)) {
				return edge.getLength();
			}
		}
		throw new IllegalArgumentException("Could not find in "+start.getEdges()+" end "+end);
	}
	
	private int factorial(int number) {
		int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}
