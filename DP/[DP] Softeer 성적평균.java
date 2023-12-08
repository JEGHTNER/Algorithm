import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int dp[];
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      dp = new int[N + 1];
      st = new StringTokenizer(br.readLine());
      for(int i = 1; i <= N; i++){
        dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
      }
      // System.out.println(Arrays.toString(dp));
      for(int i = 0; i < K; i++){
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        double ans = (dp[B] - dp[A-1]) / (double)(B - A + 1);
        System.out.println( String.format("%.2f", ans) );
      }
    }
}
// 10 50 20 70 100
// 10 60 80 150 250
// dp[B] - dp[A-1];
