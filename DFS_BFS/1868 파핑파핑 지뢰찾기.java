import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int T, N, toClick;
	static int arr[][];
	static int visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (input[j] == '.') {
						arr[i][j] = 0;
					}
					else {
						arr[i][j] = -1;
					}
				}
			}
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(arr[k]));
//			}
//			System.out.println(Arrays.deepToString(arr));
			toClick = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == -1) continue;
					if (check(i, j)) continue;
					arr[i][j] = 2;
				}
			}

//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(arr[k]));
//			}System.out.println();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] != 0 || arr[i][j] != 0) continue;
					cnt++;
					bfs(i, j, cnt);
				}
			}
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(arr[k]));
//			}System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 2) cnt++;
				}
			}
			System.out.println("#" +tc+" "+cnt);
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}System.out.println();
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(arr[k]));
//			}
		}
	}
	static void bfs(int i, int j, int cnt) {
		Queue<int []> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		visited[i][j] = cnt;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			if (arr[r][c] == 2) {
				arr[r][c] = 1;
				continue;
			}
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (visited[nr][nc] != 0 || arr[nr][nc] == -1) continue;
				visited[nr][nc] = cnt;
//				arr[nr][nc] = 1;
//				for (int k = 0; k < N; k++) {
//					System.out.println(Arrays.toString(visited[k]));
//				}System.out.println();
				queue.add(new int[] {nr, nc});
			}
		}
	}

	static boolean check(int r, int c) {
//		System.out.println("r = " + r + " c = " + c);
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
//			System.out.println("nr = " + nr + " nc = " + nc + " 지뢰? " + arr[nr][nc]);
			if (arr[nr][nc] == -1) return false;
		}
		return true;
	}
}
