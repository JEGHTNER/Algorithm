import java.io.*;
import java.util.*;

public class Solution {

	static int T;
	static int[] price; // 0 : 일 , 1: 1달, 2 : 3달, 3: 1년
	static int[] months;
	static int[] dp;
	static int[] visited;
	static int ans;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			months = new int[12];
			dp = new int[12];
			visited = new int[12];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.print("#" +tc+ " ");
			System.out.println(Math.min(ans, price[3]));
		}
	}
	static void dfs(int depth, int sum) {
		if (depth >= 12) {
			ans = Math.min(ans, sum);
			return;
		}
		dfs(depth + 1, sum + price[0] * months[depth % 12]);
		dfs(depth + 1, sum + price[1]);
		dfs(depth + 3, sum + price[2]);
	}

}
