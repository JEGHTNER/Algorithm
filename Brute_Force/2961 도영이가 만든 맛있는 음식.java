import java.io.*;
import java.util.*;

public class boj2961 {

	static int N;
	static int[] bitter;
	static int[] sour;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sour = new int[N];
		bitter = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		generateSubset(0);
		System.out.println(ans);
		
		
	}
	private static void generateSubset(int depth) {
		if (depth == N) { // 부분 집합 완성
			
			// 부분집합의 구성원소의 합을 구하고 sum과 비교
			int s_mul = 1, b_sum = 0, tCnt = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					b_sum += bitter[i];
					s_mul *= sour[i];
					tCnt++;
				}
			}
			if (tCnt <= 0) {
				return ;
			}
//			System.out.println(b_sum + " " + s_mul + " " +(b_sum - s_mul));
			ans = Math.min(ans, Math.abs(b_sum - s_mul));
//			for (int i = 0; i < N; i++) {
//				if (visited[i]) {
//					System.out.print(input[i] + "\t");
//				}
//			}
			return;
		}
		visited[depth] = true;
		generateSubset(depth + 1);
		visited[depth] = false;
		generateSubset(depth + 1);
	}

}
