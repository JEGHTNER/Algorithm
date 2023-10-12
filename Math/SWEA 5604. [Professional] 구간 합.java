import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long[] ans = new long[10];
			long point = 1;
			while (A <= B) {
				
				while (B % 10 != 9 && A <= B) {
//					System.out.println("A = " + A + " B = " + B);
					cal(B, ans, point);
					B--;
				}
//				System.out.println("B:       " + B);
				if (B < A) {
					break;
				}
//				System.out.println(Arrays.toString(ans));
				while (A % 10 != 0 && A <= B) {
//					System.out.println("A = " + A + " B = " + B);
					cal(A, ans, point);
					A++;
				}
//				System.out.println("A:       " + A);
				A /= 10;
				B /= 10;
//				System.out.println("B2:       " + B);
//				System.out.println("A2:       " + A);
				for (int i = 0; i < 10; i++) {
					ans[i] += (B - A + 1) * point;
				}
				point *= 10;
			}
//			System.out.println(Arrays.toString(ans));

			long sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += (ans[i] * i);
			}

			System.out.println("#" + tc + " " + sum);
		}
	}

	public static void cal(long x, long[] ans, long point) {
		while (x > 0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length() - 1) - '0';
			ans[xx] += point;
			x /= 10;
		}
	}
}
