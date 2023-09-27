import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, ans;
	static int[][] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && distance[i][j] == 0) {
						distance[i][j] = 1000000;
					}
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k) continue;
					for (int j = 0; j < N; j++) {
						if (j == k || j == i) continue;
						distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(distance[i]));
//			}
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += distance[i][j];
				}ans = Math.min(ans, sum);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
