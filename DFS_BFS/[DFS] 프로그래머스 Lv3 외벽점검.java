import java.util.*;

class Solution {
    static int weakLong[];
    static boolean visited[];
    static int permuted[];
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[] weak, int[] dist) {
        weakLong = new int[weak.length * 2];
        for(int i = 0; i < weak.length; i++){
            weakLong[i] = weak[i];
            weakLong[i + weak.length] = weak[i] + n;
        }
        // System.out.println(Arrays.toString(weakLong));
        for(int i = 0; i < weak.length; i++){
            visited = new boolean[dist.length];
            permuted = new int[dist.length];
            dfs(i, 0, dist);
        }
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    public static void dfs(int start, int depth, int[] dist){
        if (depth == dist.length){
            answer = Math.min(check(start, start + weakLong.length/2), answer);
            return;
        }
        for (int i = 0; i < dist.length; i++){
            if (visited[i]) continue;
            visited[i] = true;
            permuted[depth] = dist[i];
            dfs(start, depth + 1, dist);
            visited[i] = false;
        }
    }
    public static int check(int start, int end){
        int friend = 1; // permuted의 index
        int pos = weakLong[start] + permuted[friend-1];
        for (int i = start; i < end; i++){
            if (pos < weakLong[i]){
                friend++;
                if (friend > permuted.length){
                    return Integer.MAX_VALUE;
                }
                pos = weakLong[i] + permuted[friend-1];
            }
        }
        return friend;
    }
}
