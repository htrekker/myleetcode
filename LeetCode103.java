package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {
	public List<List<Integer>> result = new ArrayList<>();

	public void helper(TreeNode root, int level) {
		if (root == null)
			return;

		if (result.size() == level)
			result.add(new LinkedList<>());

		if (level % 2 == 0)
			result.get(level).add(root.val);
		else
			result.get(level).add(0, root.val);

		helper(root.left, level + 1);
		helper(root.right, level + 1);

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		helper(root, 0);
		return result;
	}
}
