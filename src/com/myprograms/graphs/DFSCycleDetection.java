package com.myprograms.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DFSCycleDetection {
	public static class Graph {
		private int nodes;
		private LinkedList<Integer> edges[];
		public Graph(int nodes) {
			this.nodes = nodes;
			this.edges = new LinkedList[nodes];
		}
		@Override
		public String toString() {
			return "Graph [nodes=" + nodes + ", edges=" + Arrays.toString(edges) + "]";
		}
		
		public void addEdge(int nodeA, int nodeB) {
			if(edges[nodeA] == null) {
				edges[nodeA] = new LinkedList<>();
			}
			edges[nodeA].add(nodeB);
		}
	}
	private Graph g;
	private Queue<Integer> unvisited;
	private Stack<Integer> processing;
	private Set<Integer> visited;
	
	public DFSCycleDetection(Graph g) {
		this.g = g;
		unvisited = IntStream.range(0, g.nodes).boxed().collect(Collectors.toCollection(LinkedList::new));
		processing = new Stack<>();
		visited = new HashSet<>();
	}
	
	private boolean hasCycle() {
		//get the first element in processing stack
		int curNode = processing.peek();
		if(g.edges[curNode] != null) {
			//traverse through the children of curNode
			for(int childNode : g.edges[curNode]) {
				//if processing does not contain the childNode. it means it is not forming a cycle
				if(!processing.contains(childNode)) {
					//if visited does not contain the childNode, we will traverse through that node. else don't
					if(!visited.contains(childNode)) {
						//we have to process childNode
						processing.add(childNode);
						//as we have to process childNode, we have to remove it from unvisited list
						unvisited.removeIf(n -> n == childNode);
						//as it is DFS, we have to traverse through childNode before its siblings
						if(hasCycle()) return true;
					}
				}else {
					//cycle
					System.out.println("There's a cycle");
					return true;
				}
			}
		}
		//once all children are processed, we have to move the curNode in visited list
		//and remove from processed
		processing.removeIf(n -> n == curNode);
		visited.add(curNode);
		return false;
	}
	
	public boolean detectCycle() {
		//when unvisited queue is empty, it means we have processed/visited all nodes
		while(!unvisited.isEmpty()) {
			int node = unvisited.remove();
			processing.add(node);
			if(hasCycle()) return true;
		}
		System.out.println("Done!");
		return false;
	}
}
