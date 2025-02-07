
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> graph[];
    static int degree[];
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        degree = new int[N+1];
        ans = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            degree[to]++;
        }
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0){
                pq.offer(i);
            }
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();
            ans.add(cur);
            for (int next : graph[cur]){
                degree[next]--;
                if (degree[next] == 0){
                    pq.offer(next);
                }
            }
        }
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}