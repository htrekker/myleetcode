package com.pasilo.leetcode;

public class LeetCode130 {

	public int col;
	public int row;

	// dfs模板
	public void dfs(char[][] board, int i, int j) {
		if (i > this.row - 1 || j > this.col - 1 || i < 0 || j < 0) // 判断i和j是否超过边界
			return;
		if (board[i][j] == 'X' || board[i][j] == '#') // '#'标记与边界上的'O'连通和被标访问过
			return;
		else {
			board[i][j] = '#';
			dfs(board, i - 1, j);// 上下左右各一次
			dfs(board, i + 1, j);
			dfs(board, i, j - 1);
			dfs(board, i, j + 1);
		}
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		row = board.length;// 别搞错了那个是行那个是列
		col = board[0].length;

		// 边界都来一遍
		for (int i = 0; i < col - 1; i++)
			dfs(board, 0, i);
		for (int j = 0; j < row; j++)
			dfs(board, j, col - 1);
		for (int i = col - 1; i > 0; i--)
			dfs(board, row - 1, i);
		for (int j = row - 1; j > 0; j--)
			dfs(board, j, 0);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')// 这里修改的顺序不能变，先将'O'变为'X'
					board[i][j] = 'X';
				if (board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
    }

}
