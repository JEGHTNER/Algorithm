package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4485 {
	static class Edge implements Comparable<Edge>{
		int e;
		int w;
		public Edge() {}
		public Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		@Override
		public String toString() {
			return "Edge [e=" + e + ", w=" + w + "]";
		}
		
		
	}

	static int N;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
	static ArrayList<Edge>[] graph;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			graph = new ArrayList[N * N + 1];
			for (int i = 0; i < N * N + 1; i++) {
				graph[i] = new ArrayList<>();
			}
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (!check(nr, nc)) continue;
						int s = i * N + j;
						int e = getEndPoint(s, d);
						graph[s].add(new Edge(e, arr[nr][nc]));
					}
				}
			}
//			for (int i = 0; i < N * N; i++) {
//				System.out.println(graph[i].toString());
//			}
			int ans = dijkstra();
			System.out.println("Problem "+tc+": "+ans);
			tc++;
		}
		
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N) return false;
		return true;
	}
	static int getEndPoint(int s, int d) {
		int ret = 0;
		if (d == 0) {
			ret = s + 1;
		}else if(d == 1) {
			ret = s + N;
		}else if (d == 2) {
			ret = s - 1;
		}else if (d == 3) {
			ret = s - N;
		}
		return ret;
	}
	static int dijkstra() {
		boolean visited[] = new boolean[N * N + 1];
		int distance[] = new int[N * N + 1];
		Arrays.fill(distance, 100000000);
		distance[0] = arr[0][0];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, arr[0][0]));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.e]) continue;
			visited[cur.e]= true; 
			for(Edge next : graph[cur.e]) {
				if (visited[next.e]) continue;					
                if (distance[next.e] <= distance[cur.e] + next.w) continue;
                distance[next.e] = distance[cur.e] + next.w;
                pq.offer(new Edge(next.e, distance[next.e]));
			}
		}
				
		return distance[N * N-1];
	}
}
