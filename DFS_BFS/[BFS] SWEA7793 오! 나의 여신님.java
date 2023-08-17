import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
public class Solution {

	static int T, N, M;
	static int arr[][];
	static int ans_r, ans_c, s_r, s_c, flag, ans;
	static int visited[][];
	static int d_visited[][];
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static Queue<int[]> devil;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			visited = new int[N][M];
			d_visited = new int[N][M];
			flag = 0;
			devil = new ArrayDeque<int[]>();
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				for (int j = 0; j < M; j++) {
					if (input.charAt(j) == 'S') {
						arr[i][j] = 1;
						s_r = i;
						s_c = j;
					}else if (input.charAt(j) == 'D') {
						arr[i][j] = 2;
						ans_r = i;
						ans_c = j;
					}else if (input.charAt(j) == 'X') {
						arr[i][j] = 3;
					}else if (input.charAt(j) == '*') {
						arr[i][j] = 4;
						devil.offer(new int[] {i, j});
					}else
						arr[i][j] = 0;
				}
			}
			bfs(s_r, s_c);
			if (flag == 0) {
				System.out.println("#"+tc+" GAME OVER");
			}else
				System.out.println("#"+tc+" "+ans);
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = 1;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0];
			int c = cur[1];
			if (r == ans_r && c == ans_c) {
				flag = 1; 
				ans = visited[r][c] - 1;
				return ;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (visited[nr][nc] > 0) continue;
				if (arr[nr][nc] != 0 && arr[nr][nc] != 2) continue;
				if (d_visited[nr][nc] > 0 && d_visited[nr][nc] <= visited[r][c] + 1) continue;
				visited[nr][nc] = visited[r][c] + 1;
				queue.offer(new int[] {nr, nc});
			}
//			System.out.println("S");
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(visited[k]));
//			}System.out.println();
			bfs2();
//			System.out.println("*");
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(d_visited[k]));
//			}System.out.println();
		}
	}
	static void bfs2() {
		int size = devil.size();
		while(size-- > 0) {
			int cur[] = devil.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (d_visited[nr][nc] > 0) continue;
				if (arr[nr][nc] == 3 || arr[nr][nc] == 2) continue;
				d_visited[nr][nc] = d_visited[r][c] + 1;
				devil.offer(new int[] {nr, nc});
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M) return false;
		return true;
	}
}
