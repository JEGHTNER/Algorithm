package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea5656 {

	static int T, N, W, H;
	static int[][] arr, cpyArr;
	static int[] nums, dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
	static boolean[] visited;
	static boolean[][] visitedArr;
	static int min, cnt, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			visited = new boolean[W];
			nums = new int[N];
			arr = new int[H][W];
			cpyArr = new int[H][W];
			cnt = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					cpyArr[i][j] = arr[i][j];
					if (arr[i][j] > 0) cnt++;
				}
			}
			dfs(0);
			if (min < 0) min = 0;
			System.out.println("#"+tc+" "+min);
		}
	}
	
	public static void dfs(int depth) {
		if (depth == N) {
			//arr 복원
			
			for (int i = 0; i < H; i++) {
				arr[i] = cpyArr[i].clone();
			}
//			System.out.println(Arrays.toString(nums));
			ans = cnt;
			for (int i = 0; i < N; i++) {
				hit(nums[i]);
			}
//			System.out.println(ans);
//			if (min > ans) {
//				System.out.println(Arrays.toString(nums));
//				System.out.println();
//				for (int k = 0; k < H; k++) {			
//				System.out.println(Arrays.toString(arr[k]));
//			}System.out.println();
//			}
			min = Math.min(ans, min);

			return ;
		}
		for (int i = 0; i < W; i++) {
			nums[depth] = i;
			dfs(depth + 1);
		}
	}
	public static void hit(int col) {
		visitedArr = new boolean[H][W];
		int row = 0;
		while (row < H) {
			if (arr[row++][col] != 0) {
				break ;
			}
		}
		row--;
		visitedArr[row][col] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {row, col});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			//1인경우 예외
			ans--;
//			if (ans < min) return ;
			if (arr[r][c] == 1) {
				arr[r][c] = 0;
			}else {
				int range = arr[r][c];
				arr[r][c] = 0;
				for (int i = 0; i < range; i++) {
					for (int d = 0; d < 4; d++) {
						int nr = r + i * dr[d];
						int nc = c + i * dc[d];
						if (!check(nr, nc)) continue;
						if (arr[nr][nc] == 0) continue;
						if (visitedArr[nr][nc]) continue;
						visitedArr[nr][nc] = true;
//						ans--;
//						if (arr[nr][nc] > 1) {
//							arr[nr][nc] = 0;
//						}
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
		moveBlock();
	}

	private static void moveBlock() {
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (arr[r][c] == 0) {
					pull(r, c);
				}
			}
		}
	}

	private static void pull(int r, int c) {
//		System.out.println("pull r c" + r + " " + c);
		for (int i = r; i > 0; i--) {
			arr[i][c] = arr[i - 1][c];
		}
		arr[0][c] = 0;
		
	}

	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= H || nc >= W) return false;
		return true;
	}
}
