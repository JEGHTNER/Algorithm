import java.util.*;

class Solution {
    static ArrayList<Integer> graph[];
    static boolean visited[];
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] wire : wires){
            int from = wire[0];
            int to = wire[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        // for(int k = 1; k < n; k++)
            // System.out.println(k+ " " + graph[k].toString());
        int count1 = 0;
        int count2 = 0;
        for(int[] wire: wires){
            int from = wire[0];
            int to = wire[1];
            count1 = bfs(from, to, n);
            count2 = bfs(to, from, n);
            // System.out.println(count1);
            // System.out.println(count2);
            answer = Math.min(answer, Math.abs(count1-count2));
        }
        return answer;
    }
    public int bfs(int from, int to, int size){
        int count = 0;
        visited = new boolean[size+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(from);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]){
                if (visited[next]) continue;
                visited[next] = true;
                if (!check(next,cur, from, to)) continue;
                queue.offer(next);
                count++;
            }
        }
        return count==0?1:count;
        // return count;
    }
    public boolean check(int next, int cur, int from, int to){
        // System.out.println("next = " + next + " cur = " + cur + " from = " + from + " to = " + to);
        if( (next == from && cur == to) || (next == to && cur == from)) return false;
        return true;
    } 
}