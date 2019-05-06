package com.myprograms.graphs;

import java.util.LinkedList;

public class DFSGraph{
	private int nodes;
	private int startNode;
	private LinkedList<Integer> edgePairs[];
	public DFSGraph(int nodes, int startNode){
		this.nodes = nodes;
		this.startNode = startNode;
		edgePairs = new LinkedList[nodes];
	}
	public void addEdge(int startNode, int endNode) {
		if(edgePairs[startNode] == null) {
			edgePairs[startNode] = new LinkedList<>();
		}
		edgePairs[startNode].add(endNode);
	}
	public void dfs() {
		int visited[] = new int[nodes];
		traverse(visited, startNode);
	}
	private void traverse(int[] visited, int node) {
		visited[node] = 1;
		System.out.println(node);
		for(int nextNode : edgePairs[node]) {
			if(visited[nextNode] == 0) {
				traverse(visited, nextNode);
			}
		}
		
	}
}
