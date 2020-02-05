package com.pasilo.leetcode;

public class LeetCode200_UnionFind {

	public int[] parents;
	public int count = 0;

	public int find(int n) {
		if (parents[n] < 0)
			return n;
		parents[n] = find(parents[n]);

		return parents[n];
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot)
			return;
		parents[pRoot] = qRoot;
		// parents[qRoot]--;
		count--;
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int row = grid.length;
		int col = grid[0].length;

		parents = new int[row * col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				parents[i * col + j] = -1;
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int n = i * col + j;
				if (grid[i][j] == '1') {
					count++;
					if (j + 1 < col && grid[i][j + 1] == '1')
						union(n, n + 1);
					if (i + 1 < row && grid[i + 1][j] == '1')
						union(n, n + col);
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		LeetCode200_UnionFind sol = new LeetCode200_UnionFind();
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		int n = sol.numIslands(grid);
		System.out.println(n);
	}
}
