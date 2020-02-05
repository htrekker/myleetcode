package com.pasilo.leetcode;

import java.util.HashMap;

public class LeetCode105 {

	public int[] preorder;
	public int[] inorder;
	public int current = 0;
	public HashMap<Integer, Integer> val_id_map = new HashMap<>();

	public TreeNode helper(int left, int right) {
		TreeNode root = null;

		int k = val_id_map.get(preorder[current]);
		root = new TreeNode(preorder[current]);

		if (left <= k - 1) {
			current = current + 1;
			root.left = helper(left, k - 1);
		}
		if (k + 1 <= right) {
			current = current + 1;
			root.right = helper(k + 1, right);
		}

		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		
		this.preorder = preorder;
		this.inorder = inorder;

		int id = 0;
		for (Integer val : inorder) {
			val_id_map.put(val, id++);
		}

		return helper(0, preorder.length - 1);
	}

	public static void main(String[] args) {

		int[] a = { 3, 1, 2, 4 };
		int[] b = { 1, 2, 3, 4 };

		LeetCode105 h = new LeetCode105();
		h.buildTree(a, b);
	}

}
