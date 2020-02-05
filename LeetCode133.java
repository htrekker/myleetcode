package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class LeetCode133 {

	public HashMap<Integer, Node> val_2_node = new HashMap<>();
	public boolean[] visited = new boolean[100];

	public Node helper(Node node) {

		Node copy = new Node(node.val);
		val_2_node.put(node.val, copy);
		
		if (!visited[node.val - 1]) {
			
			ArrayList<Node> _neighbors = new ArrayList<>();
			
			for (Node neighbor : node.neighbors) {
				if (val_2_node.containsKey(neighbor.val)) {
					_neighbors.add(val_2_node.get(neighbor.val));
				} else {
					_neighbors.add(helper(neighbor));
				}
			}
			
			visited[node.val - 1] = true;
			copy.neighbors = _neighbors;
		}

		return copy;
	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		if (node.neighbors.size() == 0)
			return new Node(1);

		return helper(node);
	}
}
