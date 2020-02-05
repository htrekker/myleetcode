package com.pasilo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
	public List<List<Integer>> helper(int[] nums, int n) {
		if (nums.length > 0 && n == 0) {
			List<List<Integer>> subsets = new ArrayList<>();
			subsets.add(new ArrayList<Integer>());
			List<Integer> set = new ArrayList<Integer>();
			set.add(nums[0]);
			subsets.add(set);
			return subsets;
		}

		List<List<Integer>> newList = new ArrayList<>();
		List<List<Integer>> sets = helper(nums, n - 1);
		for (List<Integer> set : sets) {
			List<Integer> t = new ArrayList<>(set);
			t.add(nums[n - 1]);
			newList.add(t);
		}
		sets.addAll(newList);

		return sets;
	}

	public List<List<Integer>> subsets(int[] nums) {
		return helper(nums, nums.length);
	}
}
