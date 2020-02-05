package com.pasilo.leetcode;

import org.junit.platform.commons.util.StringUtils;

public class LeetCode124 {
	public int max = Integer.MIN_VALUE;

	public int helper(TreeNode root) {
		if (root.left == null && root.right == null) {
			if (root.val > max)
				max = root.val;
			return root.val > 0 ? root.val : 0;
		}

		int lVal = 0, rVal = 0;
		if (root.right != null)
			rVal = helper(root.right);
		if (root.left != null)
			lVal = helper(root.left);

		int temp = lVal + rVal + root.val;

		int tmax = rVal + root.val > lVal + root.val ? rVal + root.val : lVal + root.val;
		int ll = temp > tmax ? temp : tmax;
		if (ll > max)
			max = ll;

		if (tmax < 0)
			return 0;
		if (tmax < root.val)
			return root.val;
		return tmax;
	}

	public int maxPathSum(TreeNode root) {
		helper(root);

		return max;
	}

	public static void main(String[] args) {

		int i = 0;
		String s = "sdf";
		Long befor = System.currentTimeMillis();
		while (i < Integer.MAX_VALUE) {
			if (StringUtils.isNotBlank(s)) {
				++i;
			} else {
				++i;
			}
		}
		i = 0;

		Long medium = System.currentTimeMillis();
		while (i < Integer.MAX_VALUE) {
			i = StringUtils.isBlank(s) ? (++i) : (++i);
		}
		Long end = System.currentTimeMillis();
		System.out.println("if(){}else{}==" + (medium - befor));
		System.out.println("?:==" + (end - medium));

	}
}
