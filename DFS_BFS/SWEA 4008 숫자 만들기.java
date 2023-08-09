import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, max, min;
	static int[] operator;
	static int[] nums;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			operator = new int[4];
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(operator.toString());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(0, nums[0]);
			System.out.println("#"+tc+" " +Math.abs(max - min));
		}
	}
	static void dfs(int depth, int sum) {
		
		if (depth == N - 1) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return ;
		}
		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0) continue;
			if (operator[i] > 0) {
				operator[i]--;
			dfs(depth + 1, calc(i, sum, depth));
			operator[i]++;
		}
	}
	}
	static int calc(int op, int sum, int depth) {
			if (op == 0) {
				return sum + nums[depth + 1];
			}else if (op == 1) {
				return sum - nums[depth + 1];
			}else if (op == 2) {
				return  sum * nums[depth + 1];
			}else {
				return (int)(sum / nums[depth + 1]);
			}
	}
}
