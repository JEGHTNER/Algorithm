import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
		int time = 0;
		int cnt = 1;
		while (cnt == 1) {
			time++;

			if (cnt >= 2 || cnt == 0) {
				break ;
			}
			cnt = 0;
			visited = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0 || visited[i][j] == 1) continue;
					bfs(i, j);
					cnt++;
				}
			}
		}
		if (cnt >= 2) {
			System.out.println(time - 1);
		}else {
			System.out.println(0);
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> melt = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		visited[i][j] = 1;
		while (queue.size() != 0) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			int cnt = 0;
			for (int d = 0; d < 4; d++) { // check 상하좌우 0
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (arr[nr][nc] == 0) {
					if (arr[r][c] > 0) {
						cnt++;
					}
				}
			}
//			System.out.println("r = " + r + " c = " + c + " cnt = " + cnt);
			melt.add(new int[] {r, c, cnt});

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (arr[nr][nc] == 0 || visited[nr][nc] == 1) continue;
				visited[nr][nc] = 1;
				queue.add(new int[] {nr, nc});
			}
		}
		while (melt.size() != 0) {
			int[] temp = melt.poll();
			int r = temp[0];
			int c = temp[1];
			int minus = temp[2];
			arr[r][c] -= minus;
			if (arr[r][c] < 0)
				arr[r][c] = 0;
		}
//		for (int k = 0; k < N; k++) {
//			System.out.println(Arrays.toString(arr[k]));
//		}
//		System.out.println();
	}
}
