import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int weight;
		public Edge(int s, int e, int weight) {
			super();
			this.s = s;
			this.e = e;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int T, V, E;
	static PriorityQueue<Edge> pq;
	static int[] p, r;
	static long min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			pq = new PriorityQueue<>();
			p = new int[V + 1];
			r = new int[V + 1];
			makeSet();
			min = 0;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				pq.add(new Edge(A, B, C));
			}
			int cnt = 0;
			while(cnt != V - 1) {
				Edge edge = pq.poll();
				if (union(edge.s, edge.e)) {
					cnt++;
					min += edge.weight;
				}
			}
			System.out.println("#"+tc+" "+min);
		}
	}
	private static boolean union(int s, int e) {
		s = find(s);
		e = find(e);
		if (s == e) return false;
		if (r[s] < r[e]) {
			r[e] += r[s];
			p[s] = e;
		}else {
			r[s] += r[e];
			p[e] = s;
		}
		return true;
	}
	private static int find(int x) {
		if (x == p[x]) return p[x];
		return p[x] = find(p[x]);
	}
	private static void makeSet() {
		for (int i = 0; i < V + 1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
}
