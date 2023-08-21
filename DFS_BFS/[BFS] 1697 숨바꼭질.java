import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static boolean visited[] = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		bfs();
	}
	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int cnt = -1;
		queue.offer(N);
		int size = 0;
		while(!queue.isEmpty()) {
			size = queue.size();
			cnt++;
			while(size-- > 0) {
				int cur = queue.poll();
				if (cur == K) {
					System.out.println(cnt);
					return ;
				}
				if (0 <= cur - 1 && cur - 1 <= 100000 && !visited[cur - 1]) {
					visited[cur - 1] = true;
					queue.offer(cur - 1);
				}
				if (0 <= cur + 1 && cur + 1 <= 100000 && !visited[cur + 1]) {
					visited[cur + 1] = true;
					queue.offer(cur + 1);
				}
				if (0 <= 2*cur && 2*cur <= 100000 &&!visited[2 * cur])
				queue.offer(2 * cur);
			}
		}
	}
}
