import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int[] dp = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int j = 0;
			dp[0] = nums[0];
			for (int i = 1; i < n; i++) {
//				System.out.println("i= "+i +" j= "+ j+ " num = " + nums[i]);
				if (nums[i] > dp[j])
					dp[++j] = nums[i];
				else {
					int temp = Arrays.binarySearch(dp, 0, j, nums[i]);
//					int temp = Arrays.binarySearch(dp, nums[i]);
//					System.out.println(temp);
					if (temp < 0) {
						temp = -temp - 1;// 4-1
					}

					dp[temp] = nums[i];
//					System.out.println("temp = "+ temp + " i =" + i + " num = "+nums[i]);
//					System.out.println("su= "+ Arrays.toString(nums));
//					System.out.println("dp= "+ Arrays.toString(dp));
				}
//				System.out.println("su= "+ Arrays.toString(nums));
//				System.out.println("dp= "+ Arrays.toString(dp));
			}
//			System.out.println("su= "+ Arrays.toString(nums));
//			System.out.println("dp= "+ Arrays.toString(dp));
			System.out.println("#" + t + " " + (j + 1));
		}
	}
}
/*
static int[] dp;
	static int ans;

	static int[] nums;
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 1;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[N];
			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j <= i - 1; j++) {
					if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						ans = Math.max(dp[i], ans);
					}
//					System.out.println(i + " " + j + " " + Arrays.toString(dp));
				}
			}
//			System.out.println(Arrays.toString(dp));
			System.out.println("#"+tc+" " +ans);
		}
	}
*/

