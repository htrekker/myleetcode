package com.pasilo.leetcode;

public class LeetCode11 {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;

		int left = 0;
		int right = height.length - 1;
		int max = 0;

		while (left < right) {
			int cap = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
			if (cap > max)
				max = cap;
			if (height[left] < height[right])
				++left;
			else
				--right;
		}
		return max;
	}
}
