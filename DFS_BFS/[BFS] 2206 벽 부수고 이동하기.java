import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int[][] visited2;
	static int[] dr = {0, -1, 0, 1}, dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		visited2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input[j] -'0';
			}
		}
		bfs();
		int ans = visited[N - 1][M - 1];
		int ans2 = visited2[N - 1][M - 1];
		if (ans == 0 && ans2 == 0) System.out.println(-1);
		else {
			if (ans == 0) ans = Integer.MAX_VALUE;
			if (ans2 == 0) ans2 = Integer.MAX_VALUE;
			System.out.println(Math.min(ans, ans2));
		}
	}
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0, 0, 0});
		visited[0][0] = 1;
		visited2[0][0] = 1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int flag = cur[2];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (visited[nr][nc] > 0) continue;
				if (arr[nr][nc] == 1) {
					if (flag == 1) continue;
					visited2[nr][nc] = visited[r][c] + 1;
					queue.offer(new int []{nr, nc, 1});
					continue;
				}
				if (flag == 0) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.offer(new int[] {nr, nc, 0});
				}
				else if (flag == 1) {
					if (visited2[nr][nc] > 0) continue;
					visited2[nr][nc] = visited2[r][c] + 1;
					queue.offer(new int[] {nr, nc, 1});
				}
			}
//			System.out.println("visited");
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(visited[k]));
//			}System.out.println();
//			System.out.println("visited2");
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(visited2[k]));
//			}System.out.println();
		}
	}
	static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M) return false;
		return true;
	}
}
