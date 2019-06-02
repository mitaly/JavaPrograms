package com.myprograms.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Kruskal {

	public static class Graph {

		private class Edge implements Comparable<Edge> {
			int nodeA, nodeB, cost;

			public Edge(int nodeA, int nodeB, int cost) {
				super();
				this.nodeA = nodeA;
				this.nodeB = nodeB;
				this.cost = cost;
			}

			@Override
			public int compareTo(Edge o) {
				return cost - o.cost;
			}

			@Override
			public String toString() {
				return "Edge [nodeA=" + nodeA + ", nodeB=" + nodeB + ", cost=" + cost + "]";
			}

		}

		private class Node {
			int data;
			int rank;
			Node parent;
		}

		int numNodes;
		//this priority queue will be sorted acc. to cost as per Egde's compareTo method
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		//For union-find algorithm for cycle detection of undirected graph
		Map<Integer, Node> nodes = new HashMap<>();

		public Graph(int numNodes) {
			this.numNodes = numNodes;
			for (int i = 0; i < numNodes; i++) {
				Node node = new Node();
				node.data = i;
				node.parent = node;
				nodes.put(i, node);
			}
		}

		public void addEdge(int nodeA, int nodeB, int cost) {
			edges.add(new Edge(nodeA, nodeB, cost));
		}

		private Node getNodeForData(int data) {
			return nodes.get(data);
		}
	}

	private Graph graph;

	public Kruskal(Graph graph) {
		this.graph = graph;
	}

	public void mst() {
		int edgesIncluded = 0;
		int totalCost = 0;
		List<com.myprograms.graphs.Kruskal.Graph.Edge> result = new LinkedList<>();
		
		while (edgesIncluded < graph.numNodes - 1) {
			com.myprograms.graphs.Kruskal.Graph.Edge edge = graph.edges.poll();
			if (edge != null && !isFormingCycle(edge)) {
					result.add(edge);
					totalCost += edge.cost;
					edgesIncluded++;
			}
		}
		result.stream().forEach(edge -> System.out.println(edge.nodeA + " -> " + edge.nodeB + " Cost: " + edge.cost));
		System.out.println("**************");
		System.out.println("Total cost:"+totalCost);
	}

	// below 2 methods are used for cycle detection - union find algorithm
	private boolean isFormingCycle(com.myprograms.graphs.Kruskal.Graph.Edge edge) {
		com.myprograms.graphs.Kruskal.Graph.Node nodeA = graph.getNodeForData(edge.nodeA);
		com.myprograms.graphs.Kruskal.Graph.Node nodeB = graph.getNodeForData(edge.nodeB);

		com.myprograms.graphs.Kruskal.Graph.Node parentA = find(nodeA);
		com.myprograms.graphs.Kruskal.Graph.Node parentB = find(nodeB);

		if (parentA == parentB) {
			// cycle
			return true;
		}
		if (parentA.rank < parentB.rank) {
			parentA.parent = parentB;
		} else if (parentA.rank > parentB.rank) {
			parentB.parent = parentA;
		} else {
			parentA.rank++;
		}

		return false;
	}

	private com.myprograms.graphs.Kruskal.Graph.Node find(com.myprograms.graphs.Kruskal.Graph.Node node) {
		if (node == node.parent) {
			return node;
		} else {
			node.parent = find(node.parent);
			return node.parent;
		}
	}
}
