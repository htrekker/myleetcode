package com.pasilo.leetcode;

public class LeetCode8 {

	public static int myAtoi(String str) {
		if (str == null)
			return 0;

		char[] chs = str.trim().toCharArray();

		boolean negative = false;
		int cur = 0;
		int result = 0;
		int multmin;
		int digit;

		// 判断是否合法
		int limit = -Integer.MAX_VALUE;
		if (chs.length == 0)
			return 0;
		if (!Character.isDigit(chs[0])) {
			if (chs[0] == '-') {
				negative = true;
				limit = Integer.MIN_VALUE;
			} else {
				if (chs[0] != '+')
					return 0;
			}
			cur++;
		}

		multmin = limit / 10;
		while (cur < chs.length) {

//			digit = Character.digit(chs[cur++], 10);
			digit = (char) (chs[cur++] - '0');
//			System.out.println(digit);
			if (digit > 9 || digit < 0)
				break;
			if (result < multmin)
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			result *= 10;
			if (result < limit + digit)
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

			result -= digit;// 按负数计算，因为负数表示的范围比正数大
		}

		return negative ? result : -result;
	}

	public static void main(String[] args) {
		String first = "891 with";
		int result = LeetCode8.myAtoi(first);

		first.equals("");

		System.out.println(result);
	}
}
