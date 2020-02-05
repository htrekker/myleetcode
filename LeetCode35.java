package com.pasilo.leetcode;

public class LeetCode35 {

	public static int searchInsert(int[] nums, int target) {

		int left = 0, right = nums.length - 1;

		while (left <= right) { // 这里必须有等号
			int mid = left + (right - left) / 2; // 防止溢出

			if (nums[mid] >= target)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };

		int flag = LeetCode35.searchInsert(nums, 5);

		System.out.println(flag);
	}
}
