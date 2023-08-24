import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, min;
	static ArrayList<Integer>[] graph;
	static int arr[];
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			arr[j + 1] = Integer.parseInt(st.nextToken());
			graph[j + 1] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int e = Integer.parseInt(st.nextToken());
				graph[i + 1].add(e);
			}
		}
		generateSubset(0, 0, 0);
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	private static void generateSubset(int depth, int sum, int sum2) {
		if (depth == N) { // 부분 집합 완성
			// 부분집합의 구성원소의 합을 구하고 sum과 비교
//			if (min < Math.abs(sum - sum2)) {
//				return ;
//			}
			int []isVisited = new int[N + 1];
			int []isVisited2 = new int[N + 1];
			int toVisit1 = 0, toVisit2 = 0;
			int tCnt = 0;
			for (int i = 1; i <= N; i++) {
				if (visited[i]) {
					toVisit1 = i;
					isVisited[i] = 1;
					sum += arr[i];
					tCnt++;
				}else {
					toVisit2 = i;
					isVisited2[i] = 1;
					sum2+= arr[i];
				}
			}
			if (tCnt == 0) {
				return ;
			}
//			for (int i = 1; i <= N; i++) {
//				if (visited[i]) {
//					System.out.print(arr[i] + "\t");
//				}
//			}
			bfs(toVisit1, isVisited);
			bfs(toVisit2, isVisited2);
			for (int i = 0; i < N + 1; i++) {
				if (isVisited[i] != 0) return ;
				if (isVisited2[i] != 0) return ;
			}
			min = Math.min(Math.abs(sum - sum2), min);
//			System.out.println("sum =" + sum + " sum2 = "+sum2 + " min = " + min);
			return;
		}

		visited[depth] = true;
		generateSubset(depth + 1, sum, sum2);
		visited[depth] = false;
		generateSubset(depth + 1, sum, sum2);
	}
	private static void bfs(int i, int[] isVisited) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(i);
		isVisited[i] = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int j = 0; j < graph[current].size(); j++) {
				int idx = graph[current].get(j);
				if (isVisited[idx] == 0) continue;
				isVisited[idx] = 0;
				queue.offer(idx);
			}
		}
	}
}
