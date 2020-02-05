package com.pasilo.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	void setVal(int val) {
		this.val = val;
	}
}

public class LeetCode19 {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head, pre = null, target = head;

		for (int i = 0; i < n; i++) {
			cur = cur.next;
		}
		target = head;
		while (cur != null) {
			cur = cur.next;
			pre = target;
			target = target.next;
		}

		if(pre != null) pre.next = target.next;
		else return target.next;

		return head;
	}
	
	public static void display(ListNode head) {
		ListNode cur = head;
		
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		ListNode[] nodes = new ListNode[5];

		for (int i = 0; i < 5; i++) {
			nodes[i] = new ListNode(5 - i);
//			nodes[i].setVal(i);
			if (i > 0) {
				nodes[i].next = nodes[i - 1];
			}
		}
		
		display(nodes[4]);
		System.out.println("---------");
		ListNode r = removeNthFromEnd(nodes[0], 1);
		display(r);
	}
}
