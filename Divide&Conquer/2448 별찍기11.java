package startcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class starprint11 {
	static int N;
	static int[][] triangle;
	
	public static void main(String[] args) throws Exception {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		triangle = new int[N][2 * N - 1];
		
		triangle(0, 0, N);
		
		StringBuilder sb = new StringBuilder(); // mutable
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < 2 * N - 1; j++)
				sb.append(triangle[i][j] == 1?"*":" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void triangle(int row, int col, int n) {
		if (n == 3) {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 5; j++) {
					if (i == 0 && j == 2) triangle[row + i][col + j] = 1;
					else if (i == 1 && (j == 1 || j == 3)) triangle[row + i][col + j] = 1;
					else if (i == 2) triangle[row + i][col + j] = 1;
				}
		}
		else {
			triangle(row, col + n/2, n/2);
			triangle(row + n/2, col, n/2);
			triangle(row + n/2, col + n, n/2);
		}
	}
}

