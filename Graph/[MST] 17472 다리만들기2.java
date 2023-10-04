import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
	}

	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<int[]>[] islands, graph;
	static PriorityQueue<Edge> pq;
	static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}, p, r;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		islands = new ArrayList[7];
		graph = new ArrayList[7];
		pq = new PriorityQueue<>();
		for (int i = 0; i < 7; i++) {
			islands[i] = new ArrayList<>();
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) continue;
				if (arr[i][j] == 1)
					bfs(i, j, cnt++);
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}System.out.println();
		for (int i = 1; i < 7; i++){
			for (int[] a : islands[i]) {
				getDistance(a[0], a[1], i);
//				System.out.print(Arrays.toString(a));
			}
//			System.out.println();
		}
//		System.out.println();
//		System.out.println(pq);
		cnt--;
		p = new int[cnt + 1];
		r = new int[cnt + 1];
		makeSet(cnt);
		int count = 0; // V - 1 회 반복
		int min = 0;
		while (count != cnt - 1) {
			Edge edge = pq.poll();
			if (edge == null) {
				min = -1;
				break;
			}
			if (union(edge.s, edge.e)) {
				count++;
				min += edge.w;
			}
		}
		System.out.println(min);
	}
	static void bfs(int i, int j, int cnt) {
//		System.out.println(i+" " + j+ " " +cnt);
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		arr[i][j] = cnt;
		islands[cnt].add(new int[] {i, j});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (arr[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				arr[nr][nc] = cnt;
				queue.offer(new int[] {nr,nc});
				islands[cnt].add(new int[] {nr, nc});
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M) return false;
		return true;
	}
	private static int getDistance(int i, int j, int num) {
		int distance = 0;
		Stack<int []> stack = new Stack<>();
		stack.add(new int[] {i, j});
		while(!stack.isEmpty()) {
			int[] cur = stack.pop();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int cnt = 0;
				int tmpr = r;
				int tmpc = c;
				while(true) {
					int nr = tmpr + dr[d];
					int nc = tmpc + dc[d];
					if (!check(nr, nc)) break;
					if (arr[nr][nc] == num) break;
					if (arr[nr][nc] > 0 && arr[nr][nc] != num) {
						if (cnt > 1) {
//							System.out.println(num + " " + arr[nr][nc] + " " + cnt + " " + nr + " " + nc );
							pq.offer(new Edge(num, arr[nr][nc], cnt));
						}
						break;
					}
					cnt++;
					tmpr = nr;
					tmpc = nc;
				}
			}
		}
		return distance;
	}
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}

	private static int find(int x) {
		if (x == p[x])
			return p[x];
		else
			return p[x] = find(p[x]);
	}

	private static void makeSet(int cnt) {
		for (int i = 0; i < cnt + 1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
}
