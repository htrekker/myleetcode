package com.pasilo.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode110 {
	public HashMap<TreeNode, Integer> node_depth = new HashMap<>();

	public int getHeight(TreeNode root, int height) {
		if (root == null)
			return 0;
		if (node_depth.containsKey(root))
			return node_depth.get(root);

		int maxDepth = 0;
		if (root.left != null) {
			maxDepth = Math.max(getHeight(root.left, height + 1), maxDepth);
		}
		if (root.right != null) {
			maxDepth = Math.max(getHeight(root.right, height + 1), maxDepth);
		}

		node_depth.put(root, maxDepth + 1);
		return maxDepth + 1;

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		int lDepth = getHeight(root.left, 0);
		int rDepth = getHeight(root.right, 0);

		return Math.abs(lDepth - rDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);

	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static String int2dListToString(List<List<Integer>> nums) {
		StringBuilder sb = new StringBuilder("[");
		for (List<Integer> list : nums) {
			sb.append(integerArrayListToString(list));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);
//			line = in.readLine();
//			int sum = Integer.parseInt(line);

			boolean ret = new LeetCode110().isBalanced(root);

//			String out = int2dListToString(ret);

			System.out.print(ret);
		}
	}
}
