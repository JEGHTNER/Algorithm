import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M, gtCnt, ltCnt, ans;
	static ArrayList<Integer>[] graph, r_graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			graph = new ArrayList[N + 1];
			r_graph = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
				r_graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				r_graph[end].add(start);
			}
			for (int i = 1; i < N + 1; i++) {
				gtCnt = ltCnt = 0;
				gtCnt = bfs(i, graph);
				ltCnt = bfs(i, r_graph);
//				System.out.println(gtCnt + " " + ltCnt);
				if (gtCnt + ltCnt == N-1) {
					ans++;
				}
			}
			System.out.println("#"+tc+ " " +ans);
		}
	}
	static int bfs(int vertex, ArrayList<Integer>[] cur_graph) {
		visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		int cnt = 0;
		visited[vertex] = true;
		queue.offer(vertex);
		while (! queue.isEmpty()) {
			int cur = queue.poll();
			for(Integer v : cur_graph[cur]) {
				if (visited[v]) continue;
				visited[v] = true;
				queue.offer(v);
				cnt++;
			}
		}
		return cnt;
	}
}
