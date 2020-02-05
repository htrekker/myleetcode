package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LeetCode94 {
	
	public static List<Integer> list = new ArrayList<>();
	
	public void helper(TreeNode node) {
		if(node == null) return;
		helper(node.left);
		list.add(node.val);
		helper(node.right);
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
		helper(root);
		return list;
	}
}
