package com.pasilo.leetcode;

public class LeetCode226 {
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode temp = invertTree(root.left);
			root.left = invertTree(root.right);
			root.right = temp;
		}

		return root;
	}
}
