package com.pasilo.leetcode;

public class LeetCode200_DFS {

	public int row;
	public int col;

	public void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i > row - 1 || j > col - 1)
			return;
		if (grid[i][j] == '0' || grid[i][j] == '2')
			return;
		else {
			grid[i][j] = '2';
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}
	}

	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0)
            return 0;
		int count = 0;

		col = grid.length;
		row = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

}
