package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode107 {
	public List<List<Integer>> result = new ArrayList<>();
	public int max_level = -1;

	public void helper(TreeNode root, int level) {
		if (root == null)
			return;

		if (result.size() == level) {
			max_level++;
			result.add(0, new LinkedList<>());
		}

		if (level % 2 == 0)
			result.get(max_level - level).add(root.val);
		else
			result.get(max_level - level).add(root.val);

		helper(root.left, level + 1);
		helper(root.right, level + 1);

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		helper(root, 0);
		return result;
	}
}
