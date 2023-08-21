import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] graph;
	static PriorityQueue<Integer> pq;
	static int[] edgeCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		edgeCount = new int[N + 1];
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A].add(B);
			edgeCount[B]++;
		}
		for (int i = 1; i < N + 1; i++) {
			if (edgeCount[i] == 0)
				pq.offer(i);
		}
		while (!pq.isEmpty()) {
			int current = pq.poll();
			sb.append(current + " ");
			List<Integer> list = graph[current];
			for (int i = 0; i < list.size(); i++) {
				int tmp = list.get(i);
				edgeCount[tmp]--;
				if (edgeCount[tmp] == 0)
					pq.offer(tmp);
			}
		}
		System.out.println(sb);
	}
}
