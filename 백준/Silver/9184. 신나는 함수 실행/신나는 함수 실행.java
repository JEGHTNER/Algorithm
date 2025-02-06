
import java.io.*;
import java.util.*;

public class Main {

    public static void init_dp(int arr[][][]){
        for(int i = 0; i <= 20; i++){
            for(int j = 0; j <=20; j++){
                for(int k = 0; k <= 20; k++){
                    arr[i][j][k] = 1;
                }
            }
        }
        for(int i = 1; i <= 20; i++){
            for(int j = 1; j <=20; j++){
                for(int k = 1; k <= 20; k++){
                    if(i < j && j < k){
                        dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                    }
                    else dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                }
            }
        }
    }
    public static int w(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <=0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20];
        }
        return dp[a][b][c];
    }
    static int dp[][][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[21][21][21];
        init_dp(dp);
//        for(int i = 0; i <= 20; i++){
//            for(int j = 0; j <= 20; j++){
//                for(int k = 0; k <=20; k++){
//                    System.out.print(dp[i][j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            int ans = w(a,b,c);
            System.out.println("w("+a+", " +b+", "+c+")" +" = "+ ans);
        }
    }
}