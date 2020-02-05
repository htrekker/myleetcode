package com.pasilo.leetcode;

public class LeetCode33 {

	public static int binSearch(int[] nums, int left, int right, int target) {
		if (left > right)
			return -1;

		int mid = (left + right) / 2;
		if (nums[mid] == target)
			return mid;

		if (nums[mid] > nums[right] && (nums[right] >= target || nums[mid] <= target))
			return binSearch(nums, mid + 1, right, target);
		else if (nums[mid] < target && target <= nums[right])
			return binSearch(nums, mid + 1, right, target);
		else
			return binSearch(nums, left, mid - 1, target);
	}

	public static int search(int[] nums, int target) {
		return binSearch(nums, 0, nums.length - 1, target);
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 8, 1, 2, 3 };

		int flag = LeetCode33.search(nums, 3);

		System.out.println(flag);
	}
}
