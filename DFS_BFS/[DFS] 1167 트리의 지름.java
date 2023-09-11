import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int num;
		int weight;
		public Edge(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [num=" + num + ", weight=" + weight + "]";
		}
		
	}

	static int V;
	static ArrayList<Edge>[] graph;
	static boolean visited[];
	static int max = Integer.MIN_VALUE;
	static int maxNode = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		visited = new boolean[V + 1];
		graph = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int input = Integer.parseInt(st.nextToken());
			while (input != -1) {
				int weight = Integer.parseInt(st.nextToken());
				graph[idx].add(new Edge(input, weight));
				input = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 0; i < V + 1; i++) {
//			System.out.println(i+" " + graph[i].toString());
//		}
			dfs(1, 0);
			dfs(maxNode, 0);
		System.out.println(max);
	}
	static void dfs(int num, int sum) {
//		System.out.println("num = " + num + " sum = " + sum);
//		System.out.println(Arrays.toString(visited));
		visited[num] = true;
		for (int i = 0; i < graph[num].size(); i++) {
			if (visited[graph[num].get(i).num]) continue;
			visited[graph[num].get(i).num] = true;
			dfs(graph[num].get(i).num, graph[num].get(i).weight + sum);
			visited[graph[num].get(i).num] = false;
		}
		if (sum > max) {
			max = sum;
			maxNode = num;
		}
//		max = Math.max(sum, max);
		visited[num] = false;
	}
}
