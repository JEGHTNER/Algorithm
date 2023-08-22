import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int V, E;
	static long min;
	static ArrayList<ArrayList<Integer>> list;
	static PriorityQueue<Edge> points;
	static int[] p, r;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		points = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			points.offer(new Edge(A, B, C));
		}
		p = new int[V + 1];
		r = new int[V + 1];
		makeSet();
		int cnt = 0; // V - 1 회 반복
		min = 0;
		while (cnt != V - 1) {
			Edge edge = points.poll();
			if (union(edge.start, edge.end)) {
				cnt++;
				min += edge.weight;
			}
		}
		System.out.println(min);
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

	private static void makeSet() {
		for (int i = 0; i < V + 1; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}

	public static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int s, int e, int w) {
			super();
			this.start = s;
			this.end = e;
			this.weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
