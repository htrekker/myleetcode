package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _LeetCode133 {
	public HashMap<Integer, Node> val_2_node = new HashMap<>();
	public boolean[] visited = new boolean[100];

	public Node cloneGraph(Node node) {
		if (node == null || val_2_node.containsKey(node.val))
			return val_2_node.get(node.val);

		visited[node.val] = true;
		ArrayList<Node> _neighbors = new ArrayList<>();
		for (Node neighbor : node.neighbors) {
			if (val_2_node.containsKey(neighbor.val))
				_neighbors.add(val_2_node.get(neighbor.val));
			else {
				if (visited[node.val])
					continue;
				_neighbors.add(cloneGraph(neighbor));
			}
		}

		Node clone = new Node(node.val, _neighbors);
		val_2_node.put(node.val, clone);

		return clone;
	}
}
