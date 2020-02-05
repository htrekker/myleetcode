package com.pasilo.leetcode;

public class LeetCode104 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int maxDepth = 0;
		if (root.left != null) {
			maxDepth = Math.max(maxDepth(root.left), maxDepth);
		}
		if (root.right != null) {
			maxDepth = Math.max(maxDepth(root.right), maxDepth);
		}

		return maxDepth + 1;
	}
}
