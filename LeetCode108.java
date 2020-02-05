package com.pasilo.leetcode;

public class LeetCode108 {
	public int[] nums;

	public TreeNode helper(int left, int right) {
		if (left > right)
			return null;

		int mid = left + (right - left + 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(left, mid - 1);
		root.right = helper(mid + 1, right);

		return root;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;
		return helper(0, nums.length - 1);
	}
}
