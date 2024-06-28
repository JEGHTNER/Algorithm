import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N,M,K;
    static int[][] arr, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
//        for(int i = 0 ; i <= N; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        for(int i = 0 ; i <= N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int ans = dp[x][y] - dp[x][j-1]-dp[i-1][y]+dp[i-1][j-1];
            System.out.println(ans);
        }
    }
}
