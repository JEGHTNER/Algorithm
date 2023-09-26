import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int[] price;
	static int[] item_weight;
	static int N, K, W, V;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][K + 1];
		price = new int[N + 1];
		item_weight = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			price[i] = V;
			item_weight[i] = W;
		}
		for (int i = 1; i <= N; i++) {
			for (int cur_weight = 1; cur_weight <= K; cur_weight++) {
				if (cur_weight < item_weight[i])
					dp[i][cur_weight] = dp[i -1][cur_weight];
				else dp[i][cur_weight] = Math.max(dp[i - 1][cur_weight], dp[i - 1][cur_weight - item_weight[i]] + price[i]);
			}
		}
//		for (int i = 0; i <= N; i++) {			
//			System.out.println(i+" "+Arrays.toString(dp[i]));
//		}
		System.out.println(dp[N][K]);
	}
}
