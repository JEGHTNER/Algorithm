import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T = 10;
	static int N, start, max;
	static HashSet<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			graph = new HashSet[101];
			visited = new boolean[101];
			for (int i = 0; i < 101; i++) {
				graph[i] = new HashSet<>();
			}
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
			}
//			for (int k = 0; k < 101; k++) {
//				System.out.println(graph[k]);
//			}
			bfs(start);
			System.out.println("#"+tc+" "+max);
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		visited[start] = true;
		int size = 0;
		int maxTmp = 0;
		while (!queue.isEmpty()) {
//			System.out.println("queue= "+queue);
			size = queue.size();
			while (size-- > 0) {
				int cur = queue.poll();
				Iterator<Integer> iter = graph[cur].iterator();
				while (iter.hasNext()) {
					int tmp = iter.next();
					if (visited[tmp])
						continue;
					visited[tmp] = true;
					queue.offer(tmp);
					maxTmp = Math.max(tmp,maxTmp);
//					System.out.println("tmp = " + tmp + " max = "+ max);
					max = maxTmp;
				}
			}maxTmp = 0;
		}
	}
}
