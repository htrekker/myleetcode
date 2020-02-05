package com.pasilo.leetcode;

import java.util.HashMap;

public class LeetCode106 {

	public int[] inorder;
	public int[] postorder;
	public HashMap<Integer, Integer> val_2_id = new HashMap<>();
	public int current;

	public TreeNode helper(int left, int right) {

		int k = val_2_id.get(postorder[current]);
		TreeNode root = new TreeNode(postorder[current]);

		if (k + 1 <= right) {
			current = current - 1;
			root.right = helper(k + 1, right);
		}
		if (left <= k - 1) {
			current = current - 1;
			root.left = helper(left, k - 1);
		}

		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0)
			return null;

		this.inorder = inorder;
		this.postorder = postorder;
		this.current = postorder.length - 1;

		for (int id = 0; id <= current; id++) {
			val_2_id.put(inorder[id], id);
		}

		return helper(0, current);
	}

	public static void main(String[] args) {

		int[] a = { 2, 1 };
		int[] b = { 2, 1 };

		LeetCode106 h = new LeetCode106();
		h.buildTree(a, b);
	}
}
