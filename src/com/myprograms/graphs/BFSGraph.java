package com.myprograms.graphs;

import java.util.LinkedList;

public class BFSGraph {
	private int nodes;
	private int startNode;
	private LinkedList<Integer> edgePairs[];
	
	public BFSGraph(int nodes, int startNode) {
		this.nodes = nodes;
		this.startNode = startNode;
		this.edgePairs = new LinkedList[nodes]; 
	}
	public void addEdge(int nodeA, int nodeB) {
		if(edgePairs[nodeA] == null) {
			edgePairs[nodeA] = new LinkedList<>();
		}
		edgePairs[nodeA].add(nodeB);
	}
	public void bfs() {
		int visited[] = new int[nodes];
		traverse(visited, startNode, new LinkedList<>());
	}
	private void traverse(int visited[], int node, LinkedList<Integer> queue) {
		visited[node] = 1;
		System.out.println(node);
		for(int nextNode : edgePairs[node]) {
			if(visited[nextNode] == 0) {
				queue.push(nextNode);
			}
		}
		Integer dequeuedNode = queue.poll();
		if(dequeuedNode != null)
			traverse(visited, dequeuedNode, queue);
	}
}
