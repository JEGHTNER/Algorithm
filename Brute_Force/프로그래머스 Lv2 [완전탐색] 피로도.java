import java.util.*;

class Solution {
    static int[] nums;
    static boolean[] visited;
    static int len, answer;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        nums = new int[len];
        visited = new boolean[len];
        answer = 0;
        perm(0, k, dungeons);
        
        return answer;
    }
    static public void perm(int depth, int sum, int[][] dungeons){
        // System.out.println(depth + " " + Arrays.toString(nums));
        answer = Math.max(depth, answer);

        if (depth == len){
            return ;
        }
        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums[depth] = i;
            if (sum < dungeons[i][0]){
                visited[i] = false;
                continue ;
            }
            perm(depth + 1, sum - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
}
