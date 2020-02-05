package com.pasilo.leetcode;

public class LeetCode50 {
	public double helper(double x, int n) {
		if (n == 0)
			return 1;

		double pow = helper(x, n / 2);

		if ((n & 1) == 1) {
			return x * pow * pow;
		}

		return pow * pow;
	}

	public double myPow(double x, int n) {
		if (n < 0)
			return helper(1 / x, n);
		return helper(x, n);
	}
}
