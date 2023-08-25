import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int e;
		int w;
		
		public Edge(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int V, E, K;
	static int[] distance;
	static boolean[] visited;
	static List<Edge>[] adj;
	static int MM = Integer.MAX_VALUE/1000;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s - 1].add(new Edge(e - 1, w));
		}
		distance = new int[V];
		Arrays.fill(distance, MM);
		visited = new boolean[V];
		pq = new PriorityQueue<>();
		pq.offer(new Edge(K - 1, 0));
		distance[K - 1] = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.e]) continue;
			visited[cur.e] = true;
			for (Edge next : adj[cur.e]) {
				if (visited[next.e]) continue;
				if (distance[next.e] > distance[cur.e] + next.w) {
					distance[next.e] = distance[cur.e] + next.w;
					pq.offer(new Edge(next.e, distance[next.e]));
				}
			}
		}
		// K -> i 
		for (int i = 0; i < V; i++) {
			if (distance[i] >= MM) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
}

