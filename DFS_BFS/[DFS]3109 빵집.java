import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	static int R,C, cnt;
	static int arr[][];
	static int dr[] = {-1, 0, 1};
	static int dc[] = {1, 1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			String input = sc.next();
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) =='.') {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < R; i++) {
			dfs(0, i, 0);
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int depth, int r, int c) {
		if (depth == C - 1) {
			cnt++;
			return true;
		}
		arr[r][c] = 1;
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] == 1) continue;
			if (dfs(depth + 1, nr, nc)) return true;
		}
		return false;
	}

}
