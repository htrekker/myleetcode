package com.pasilo.leetcode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LeetCode54 {

	private List<Integer> order = new ArrayList<>();

	public void out(int[][] matrix, int left, int top, int width, int height) {
		if (width == 0 || height == 0) {
			return;
		}

		if (width <= 1) {
			for (int i = top; i < height + top; i++) {
				order.add(matrix[i][left]);
			}
			return;
		}
		if (height <= 1) {
			for (int i = left; i < width + left; i++) {
				order.add(matrix[top][i]);
			}
			return;
		}
		for (int i = left; i < width + left; i++) {
			order.add(matrix[top][i]);
		}
		for (int i = top + 1; i < height + top; i++) {
			order.add(matrix[i][left + width - 1]);
		}
		for (int i = left + width - 2; i >= left; i--) {
			order.add(matrix[top + height - 1][i]);
		}
		for (int i = top + height - 2; i >= top + 1; i--) {
			order.add(matrix[i][left]);
		}
		out(matrix, left + 1, top + 1, width - 2, height - 2);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return order;
		}
		out(matrix, 0, 0, matrix[0].length, matrix.length);
		System.out.println(order);
		return this.order;
	}

	public static void generateData() throws IOException {
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());

		FileOutputStream data = new FileOutputStream(new File("123.txt"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(data));
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				writer.append(String.valueOf(rand.nextInt(32143124) % 3223) + " ");
			}
			writer.append("\n");
		}
	}

	public static void main(String[] args) throws IOException {
//		generateData();
		Scanner in = new Scanner(System.in);
		System.out.print("height:");
		int n = in.nextInt();
		System.out.print("width:");
		int m = in.nextInt();
		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = in.nextInt();
			}
		}

		LeetCode54 lc = new LeetCode54();
		lc.spiralOrder(matrix);

		in.close();
	}
}
