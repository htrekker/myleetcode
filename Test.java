package com.pasilo.leetcode;

import org.junit.platform.commons.util.StringUtils;

public class Test {
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
		double res = Math.pow(2, 2);
		System.out.println(res);
	}
}
