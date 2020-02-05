package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode114 {

	public List<Integer> route = new ArrayList<>();
	public Stack<TreeNode> st = new Stack<>();

	public void helper(TreeNode root) {

		while (!st.isEmpty()) {
			TreeNode node = st.pop();
			route.add(node.val);
			if (node.right != null) {
				st.push(node.right);
			}
			if (node.left != null) {
				st.push(node.left);
			}
		}

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return route;
		st.push(root);
		helper(root);
		return route;
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		root.left = node3;
		root.right = left;
		LeetCode114 h = new LeetCode114();
		List<Integer> route = h.preorderTraversal(root);

		System.out.println(route);
	}
}
