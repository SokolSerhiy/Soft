package ua;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {

	private Node node;
	
	private List<Node> nodes;
	
	private int countOfGraphes;
	
	private int countByPosition;
	
	private List<Graph> graphs = new ArrayList<>();
	
	private Map<Integer, List<Node>> map = new HashMap<>();

	public Calculator(Node node) {
		this.node = node;
		nodes = node.getEdges().stream().map(Edge::getEnd).collect(Collectors.toList());
		countOfGraphes = factorial(nodes.size());
		countByPosition = factorial(nodes.size()-1);
	}
	
	public void calculate() {
		for(int i = 0; i < countOfGraphes; i++) {
			Graph graph = new Graph();
			for(int j = 0; j < nodes.size(); j++) {
				Node previous = j == 0 ? null : graph.getNodes().get(j-1);
				Node current = nodes.get((int)(Math.random()*nodes.size()));
				if(!current.equals(previous)&&!isAlredyUsedInGraph(graph, current)&&!isAlredyUsedByPosition(j, current)) {
					graph.add(current, getLength(previous, current));
				}else {
					j--;
				}
			}
			graph.add(node, getLength(graph.getNodes().get(graph.getNodes().size()-1), node));
			graphs.add(graph);
		}
		graphs.sort(Comparator.comparing(Graph::sum));
		graphs.forEach(g->print(g));
	}
	
	private void print(Graph g) {
		StringBuilder sb = new StringBuilder();
		sb.append("From ");
		sb.append(node.getName());
		for(int i = 0; i < g.getNodes().size(); i++) {
			sb.append(" distance to ");
			sb.append(g.getNodes().get(i).getName());
			sb.append(" ");
			sb.append(g.getLength().get(i));
			sb.append("km ");
		}
		System.out.println(sb+" sum "+g.sum());
	}

	private int getLength(Node previous, Node current) {
		previous = previous == null ? node : previous;
		for(Edge edge : previous.getEdges()) {
			if(edge.getEnd().equals(current)) {
				return edge.getLength();
			}
		}
		throw new RuntimeException("Something went wrong");
	}
	
	private boolean isAlredyUsedByPosition(int position, Node current) {
		List<Node> nodes = map.get(position);
		if(nodes==null) {
			nodes = new ArrayList<>();
			nodes.add(current);
			map.put(position, nodes);
			return false;
		}else {
			int count = (int)nodes.stream().filter(n->n.equals(current)).count();
			if(count == countByPosition) {
				return true;
			}else {
				nodes.add(current);
				return false;
			}
		}
	}
	
	private boolean isAlredyUsedInGraph(Graph graph, Node node) {
		return graph.getNodes().contains(node);
	}
	
	private int factorial(int number) {
		int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}
