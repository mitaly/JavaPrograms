package com.myprograms.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Prims {
	public static class Graph {
		private class Edge implements Comparable<Edge> {
			int nodeB;
			int cost;

			public Edge(int nodeB, int cost) {
				this.nodeB = nodeB;
				this.cost = cost;
			}

			@Override
			public int compareTo(Edge o) {
				return cost - o.cost;
			}
		}

		private int numNodes;
		private List<Edge> nodesList[];

		public Graph(int numNodes) {
			this.numNodes = numNodes;
			nodesList = new LinkedList[numNodes];
		}

		public void addEdge(int nodeA, int nodeB, int cost) {
			if (nodesList[nodeA] == null) {
				nodesList[nodeA] = new LinkedList<>();
			}
			nodesList[nodeA].add(new Edge(nodeB, cost));
		}
	}

	private Graph g;
	private int totalCost = 0;
	private final int MAX_VALUE = Integer.MAX_VALUE;

	public Prims(Graph g) {
		this.g = g;
	}
	
	public void findMinimumSpanningTree(int startNode) {
		findNextNode(startNode, new HashSet<Integer>());
		System.out.println("Cost:"+totalCost);
	}

	private void findNextNode(int curNode, HashSet<Integer> visitedNodes) {
		visitedNodes.add(curNode);
		Integer nextNode = null;
		
		int minCost = MAX_VALUE;
		
		for(final int node : visitedNodes) {
			if(g.nodesList[node] != null) {
				for(com.myprograms.graphs.Prims.Graph.Edge edge : g.nodesList[node]) {
					if(!visitedNodes.contains(edge.nodeB) && edge.cost < minCost) {
						curNode = node;
						nextNode = edge.nodeB;
						minCost = edge.cost;
					}
				}
			}
		}
		
		if(nextNode == null) {
			return;
		}
		
		totalCost += minCost;
		System.out.println(curNode +" -> "+nextNode.intValue());
		findNextNode(nextNode, visitedNodes);
	}
}
