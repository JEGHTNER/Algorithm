import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] arr;
	static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
	static Queue<int[]> queue;
	static ArrayList<int [] > list_0, list_2;
	static int[] nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		nums = new int[3];

		list_0 = new ArrayList<>();
		list_2 = new ArrayList<>();
		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list_2.add(new int[] {i, j});
				}else if (arr[i][j] == 0) {
					list_0.add(new int[] {i, j});
				}
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void bfs(int[][] arrCpy) {
		queue = new ArrayDeque<>();
		for (int i = 0; i < list_2.size(); i++) {
			queue.offer(new int[] {list_2.get(i)[0], list_2.get(i)[1]});
		}
		boolean[][] visited = new boolean[N][M];
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (arrCpy[nr][nc] == 1) continue;
				visited[nr][nc] = true;
				arrCpy[nr][nc] = 2;
				queue.offer(new int[] {nr, nc});
			}
		}
	}
	static void comb(int depth, int start) {
		if (depth == 3) {
			int cnt = 0;
			int[][] arrCpy = new int[N][M];
			for (int i = 0; i < N; i++) {				
				System.arraycopy(arr[i], 0, arrCpy[i], 0, M);
			}
//			System.out.println(Arrays.toString(nums));
			for (int i = 0; i < 3; i++) {
				int r = list_0.get(nums[i])[0];
				int c = list_0.get(nums[i])[1];
				arrCpy[r][c] = 1;
			}
			bfs(arrCpy);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arrCpy[i][j] == 0) cnt++;
				}
			}
			ans = Math.max(ans, cnt);
			return ;
		}
		for (int i = start; i < list_0.size(); i++) {
			nums[depth] = i;
			comb(depth + 1, i + 1);
		}
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M) return false;
		return true;
	}
}
