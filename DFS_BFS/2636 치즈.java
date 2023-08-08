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
		int cnt = 1;
		int time = 0;
		int cheese = 0;
		while (cnt > 0) {
			time++;
			visited = new int[N][M];
			cnt = 0;
			fillAir(0, 0);
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(arr[k]));	
//			}
//			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 1 || visited[i][j] == 1) continue;
					bfs(i, j);
					cnt++;
				}
			}
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(arr[k]));	
//			}
//			System.out.println();
			if (cnt != 0)
				cheese = cnt;
		}
		System.out.println(time - 1);
		System.out.println(cheese);
	}
	static void bfs(int i, int j) {
//		System.out.println("i = "+i+ " j = "+j);
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		visited[i][j] = 2;
		while (queue.size() != 0) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for (int d = 0; d < 4; d++) { // check 상하좌우 -1
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (arr[nr][nc] == -1) {
					arr[r][c] = 0;
					continue;
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (arr[nr][nc] != 0 || visited[nr][nc] == 2) continue;
				visited[nr][nc] = 2;
				queue.add(new int[] {nr, nc});
			}
		}
		
	}
	static void fillAir(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		arr[i][j] = -1;
		visited[i][j] = 1;
		while (queue.size() != 0) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (arr[nr][nc] == 1 || visited[nr][nc] == 1) continue;
				arr[nr][nc] = -1;
				visited[nr][nc] = 1;
				queue.add(new int[] {nr, nc});
			}
		}
	}
}
