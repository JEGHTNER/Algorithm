import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {

    static int N, K, max;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N + 1];
        for (int i = 0; i  < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr));
        //dp초기화
        for(int i = 0; i < K; i++){
            dp[0] += arr[i];
        }
        max = dp[0];
//        System.out.println(Arrays.toString(dp));
        for(int i = 1; i < N - K + 1; i++){
            dp[i] = dp[i-1] + arr[i+K-1] - arr[i-1];
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
