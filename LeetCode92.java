package com.pasilo.leetcode;

import java.util.HashMap;

public class LeetCode92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m > n || m < 1)
			return head;
		int k = 0;
		ListNode empty = new ListNode(0);
		empty.next = head;
		head = empty;
		ListNode cur = head;
		while (k < m - 1) {
			cur = cur.next;
			k++;
		}
		ListNode front = cur, end = cur.next;
		ListNode q = end;

		cur = cur.next.next;
		k = k + 2;
		while (k <= n && cur != null) {
			ListNode temp = cur.next;
			cur.next = q;
			q = cur;
			cur = temp;
			k++;
		}
		front.next = q;
		end.next = cur;

		return m == 1 ? q : head.next;
	}
	
	public static int test() {
		try {
			boolean flag = true;
			System.out.println("do something...");
			if(!flag) throw new Exception("hello exception");
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println("balabalabala...");
		return -1;
	}
	
	public static void main(String[] args) {
		
		String str = new String("asdf");
		str.intern();
		HashMap<Integer, String> map = new HashMap<>();
		map.put(null, "123");
		
		System.out.println(LeetCode92.test());
	}
}
