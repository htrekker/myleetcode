package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {

	public Queue<TreeNode> queue = new LinkedList<>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		queue.add(root);
		int left = 0, mid = 1, right = 1;// mid保存这一层最后一个元素编号，right保存下一层最后一个元素编号

		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			for (int i = left; i < mid; i++, left++) {
				TreeNode temp = queue.remove();
				level.add(temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
					right++;
				}
				if (temp.right != null) {
					queue.add(temp.right);
					right++;
				}
			}
			left = mid;
			mid = right;
			result.add(level);
		}

		return result;
	}

}
