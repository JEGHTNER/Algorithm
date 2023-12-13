import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> graph[], reverseGraph[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
            reverseGraph[i] = new ArrayList<>();
        }
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            reverseGraph[v].add(u);
        }
        int ans = 0;
        for (int i = 1; i < N + 1; i++) {
            if (bfs(i) + bfs2(i) == N - 1)
                ans += 1;
        }
        System.out.println(ans);
    }
    static int bfs(int i){
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        boolean[] visited = new boolean[N + 1];
        visited[i] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int num : graph[cur]){
                if (visited[num]) continue;
                visited[num] = true;
                queue.add(num);
                ans += 1;
            }
        }
        return ans;
    }

    static int bfs2(int i){
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        boolean[] visited = new boolean[N + 1];
        visited[i] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int num : reverseGraph[cur]){
                if (visited[num]) continue;
                visited[num] = true;
                queue.add(num);
                ans += 1;
            }
        }
        return ans;
    }
}
