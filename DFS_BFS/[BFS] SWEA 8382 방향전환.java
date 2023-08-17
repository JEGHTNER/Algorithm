import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N = 200;
	static int T, x1, y1, x2, y2;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static int visited[][][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			x1 = sc.nextInt() + 100;
			y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;

			visited = new int[N + 1][N + 1][2];
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {x1, y1, 0, 0});// 거리 방향 dir = 0 d=0,2 d=1,3 양 옆
			queue.offer(new int[] {x1, y1, 0, 1});// 거리 방향 dir = 1 d=0,2 d=1,3 위 아래
			visited[x1][y1][0] = 1; //
			visited[x1][y1][1] = 1;
			int value = -1;
			while(!queue.isEmpty()) {
				int [] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				int dir = cur[3];
				if (r == x2 && c == y2) {
					value = cnt;
					break ;
				}
				for (int d = 1; d < 4; d += 2) {
					int s = (dir + d)%4; // 0 + 1 -> 1 1+1 ->2
					int u = (dir + d)%2; // new dir
					int nr = r + dr[s];
					int nc = c + dc[s];
					if (!check(nr, nc)) continue;
					if (visited[nr][nc][u] == 1) continue;
					visited[nr][nc][u] = 1;
					queue.offer(new int[] {nr, nc, cnt + 1, u});
				}
			}
			System.out.println("#"+tc+" "+value);
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N + 1 && nc >= 0 && nc < N + 1;
	}
}
