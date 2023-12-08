import java.io.*;
import java.util.*;

public class Main {

    static int N, cnt, ans;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      arr = new int[N];
      dp = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        dp[i] = 1;
      }
      for(int i = 0; i < N; i++){
        int find = 0;
        for(int j = 0; j < i; j++){
          if (arr[j] < arr[i]){
            find = Math.max(find, dp[j]);
          }
        }
        dp[i] = find + 1;
        ans = Math.max(dp[i], ans);
      }
      System.out.println(ans);
    }
}
