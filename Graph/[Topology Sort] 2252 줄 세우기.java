import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] graph; //무방향 그래프
	static int[] edgeCount; // 진입차수 저장 배열
	static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[N + 1];
		edgeCount = new int[N + 1];
		queue = new ArrayDeque<Integer>();
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A].add(B);
			edgeCount[B]++;
		}
		for (int i = 1; i < N + 1; i++) {
			if (edgeCount[i] == 0) { // 진입 차수가 0인 인덱스들 큐에 삽입
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current + " ");
			List<Integer> list = graph[current];
			for (int i = 0; i < list.size(); i++) {
				int tmp = list.get(i);
				edgeCount[tmp]--;
				if (edgeCount[tmp] == 0)
					queue.offer(tmp);
			}
		}
		System.out.println(sb);
	}
}
