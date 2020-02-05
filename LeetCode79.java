package com.pasilo.leetcode;

public class LeetCode79 {

	public static boolean isWord(char[][] board, String word, int row, int col) {

		boolean[][] visited = new boolean[board.length][board[0].length];
		
		int k = 1;
		for (int i = row; i < board.length; i++) {
			for (int j = col; j < board[0].length; j++) {
				if(board[++i][j] == word.charAt(k)) {
					visited[i][j] = true;
				}
				else if(board[i][++j] == word.charAt(k)) {
					visited[i][j] = true;
				}
			}
		}

		return false;
	}

	public static boolean exist(char[][] board, String word) {

		int m = board.length;
		int n = board[0].length;


		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++, k++) {
				if (board[i][j] == word.charAt(k)) {

				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

	}
}
