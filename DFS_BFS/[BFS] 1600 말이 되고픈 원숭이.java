import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H;
	static int arr[][];
	static boolean visited[][][];
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int [] hdr = {-2, -2, -1, 1, 2, 2, 1, -1}, hdc = {-1, 1, 2, 2, 1, -1, -2, -2};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		K = sc.nextInt();
//		W = sc.nextInt();
//		H = sc.nextInt();
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print((visited[i][j][0]));
//			}System.out.println();
//		}System.out.println();
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print((visited[i][j][1]));
//			}System.out.println();
//		}
//		for (int i = 0; i < K + 1; i++) {
//			if (visited[H - 1][W - 1][i] == 0) continue;
//			min = Math.min(min, visited[H - 1][W - 1][i]);
//		}
//		if (min == Integer.MAX_VALUE) System.out.println(-1);
//		else System.out.println(min);
		System.out.println(min);
	}
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		queue.offer(new int[] {i, j, 0, 0});
		visited[i][j][0] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			int hMove = cur[2];
			int cnt = cur[3];
			if (r == H - 1 && c == W - 1) {
				min = cnt;
				return ;
			};
			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + r;
				int nc = dc[d] + c;
				if (!check(nr, nc) || visited[nr][nc][hMove]) continue;
				if (arr[nr][nc] ==0) {
					visited[nr][nc][hMove] = true;
					queue.offer(new int[] {nr, nc, hMove , cnt + 1});
				}
			}
			if (hMove >=K) continue;
			for (int d = 0; d < 8; d++) {
				int nr = hdr[d] + r;
				int nc = hdc[d] + c;
				if (!check(nr, nc) || visited[nr][nc][hMove + 1]) continue;
				if (arr[nr][nc] ==0) {
					visited[nr][nc][hMove + 1] = true;
					queue.offer(new int[] {nr, nc, hMove + 1, cnt + 1});
				}
			}
//			for (int k = 0; k < H; k++) {
//				for (int l = 0; l < W; l++) {
//					System.out.print((visited[k][l][0]));
//				}System.out.println();
//			}System.out.println();
//			for (int k = 0; k < H; k++) {
//				for (int l = 0; l < W; l++) {
//					System.out.print((visited[k][l][1]));
//				}System.out.println();
//			}System.out.println();
		}
		min = -1;
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= H || nc >= W) return false;
		return true;
	}
}
