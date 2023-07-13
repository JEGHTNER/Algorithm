import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] star;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		star = new int[N][N];
		
		star(0, 0, N);
		
		StringBuilder sb = new StringBuilder(); // mutable
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				sb.append(star[i][j] == 1?"*":" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void star(int row, int col, int n) {
		if (n == 3) {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1) continue; // 다음 스텝->중앙일때 아무일도 안함
					star[row + i][col + j] = 1;
				}
		}
		else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i == 1 && j == 1) continue;
					star(row + i * n / 3, col + j * n / 3, n / 3);
				}	
			}
		}
	}
}
