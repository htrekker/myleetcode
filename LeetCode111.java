package com.pasilo.leetcode;

public class LeetCode111 {
	
	public int helper(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null)
			return helper(root.right) + 1;
		if (root.right == null)
			return helper(root.left) + 1;

		int lDepth = helper(root.left);
		int rDepth = helper(root.right);

		return lDepth > rDepth ? rDepth + 1 : lDepth + 1;
	}

	public int minDepth(TreeNode root) {
		return helper(root);
	}
	
}
