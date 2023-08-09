import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int w, h;
	static int arr[][];
	static boolean visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		while (true) {
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		if (w == 0 && h == 0) return;
		arr = new int[h][w];
		visited = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 0) continue;
				if (visited[i][j] == false) {
					visited[i][j] = true;
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		
		while(!queue.isEmpty()) {
			int[] temp;
			temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
				if (visited[nr][nc] == true || arr[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc});
			}
		}
	}
}
