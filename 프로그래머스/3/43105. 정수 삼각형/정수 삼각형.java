import java.util.*;

class Solution {
    static int dp[][];
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        dp = new int[size+1][size+1];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < size; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i - 1][0];
                }else if(j == i){
                    dp[i][j] = triangle[i][j] + dp[i - 1][i - 1];
                }else{
                    dp[i][j] = triangle[i][j] 
                        + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        for(int i = 0; i < size; i++){
            answer = Math.max(answer, dp[size-1][i]);
        }
        return answer;
    }
}
