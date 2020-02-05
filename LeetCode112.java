package com.pasilo.leetcode;

public class LeetCode112 {
	public int target;

	public boolean helper(TreeNode root, int sum) {

		if (root.left == null && root.right == null)
			return sum + root.val == target;
		
		boolean flag = false;
		if (root.left != null)
			flag = helper(root.left, sum + root.val);
		if (!flag && root.right != null)
			flag = flag || helper(root.right, sum + root.val);
		
		return flag;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		this.target = sum;

		return helper(root, 0);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		TreeNode leftl = new TreeNode(11);
		root.left = left;
		root.right = right;
		left.left = leftl;
		LeetCode112 h = new LeetCode112();
		boolean flag = h.hasPathSum(root, 13);
		System.out.println(flag);
	}
}
