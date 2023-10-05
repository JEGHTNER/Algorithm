import java.util.*;

class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){
            if (visited[i]) continue;
            bfs(i, n, computers);
            answer++;
        }
        System.out.println(Arrays.toString(visited));

        return answer;
    }
    static void bfs(int num, int n, int[][] computers){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(num);
        visited[num] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int j = 0; j < n; j++){
                if (computers[cur][j] == 1){
                    if (visited[j]) continue;
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
