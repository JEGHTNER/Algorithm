import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N, H;
	static int flag;
	static int max = Integer.MIN_VALUE;
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static int[][][] arr;
	static int[][][] visited;
	static Queue<int []> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];
		visited = new int[H][N][M];
		for (int i = 0 ; i <H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 0) flag = 1;
					if (tmp == 1) {
						queue.add(new int []{i, j, k});
						visited[i][j][k] = 1;
					}
					arr[i][j][k] = tmp;
				}
			}
		}
		if (flag == 0) {
			System.out.println(0);
			return ;
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (visited[i][j][k] != 0 && arr[i][j][k] != 1) continue;
					if (arr[i][j][k] == 1)
						bfs(i, j, k);
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (visited[i][j][k] == 0 && arr[i][j][k] != -1) {
						System.out.println(-1);
						return ;
					}
					max = Math.max(max, visited[i][j][k]);
				}
			}
		}
		System.out.println(max - 1);
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.println(Arrays.toString(visited[i][j]));
//			}
//		}
	}
	static void bfs(int i, int j, int k) {
		queue.add(new int[] {i, j, k});
		while(queue.size() > 0) {
			int [] tmp;
			tmp = queue.poll();
			int h = tmp[0]; int n = tmp[1]; int m = tmp[2];
			for (int d = 0; d < 6; d++) {
				int nh = tmp[0] + dh[d];
				int nr = tmp[1] + dr[d];
				int nc = tmp[2] + dc[d];
				if (nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M) continue;
				if (arr[nh][nr][nc] != 0) continue;
				if (visited[nh][nr][nc] != 0) continue;
				visited[nh][nr][nc] = visited[h][n][m] + 1;
				queue.add(new int[] {nh,nr,nc});
//				for (int a = 0; a < H; a++) {
//					for (int b = 0; b < N; b++) {
//						System.out.println(Arrays.toString(visited[a][b]));
//					}
//					System.out.println();
//				}
			}
		}
	}
}
