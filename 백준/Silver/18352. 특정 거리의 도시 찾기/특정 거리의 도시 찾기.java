
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer> graph[];
    static boolean visited[];

    public static void dijkstra(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int distance[] = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.offer(X);
        distance[X] = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            for(int next : graph[cur]){
                if(distance[cur] + 1 >= distance[next]) continue;
                distance[next] = distance[cur] + 1;
                pq.offer(next);
            }
        }
//        System.out.println(Arrays.toString(distance));
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        for(int i = 0; i <= N; i++){
            if(distance[i] == K){
                ans.offer(i);
            }
        }
        if (ans.isEmpty()) System.out.println(-1);
        else {
            while(!ans.isEmpty()){
                System.out.println(ans.poll());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
        }
        dijkstra();

    }
}
