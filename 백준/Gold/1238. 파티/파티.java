import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int e;
        int w;

        public Edge( int e, int w){
            this.e = e;
            this.w = w;
        }

        public int compareTo(Edge o){
            return this.w - o.w;
        }
        public String toString(){
            return "e= "+ this.e + " w= "+ this.w;
        }
    }
    static int N, M, X;
    static boolean visited[];
    static ArrayList<Edge>[] graph, reverseGraph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[M + 1];
        reverseGraph = new ArrayList[M + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            reverseGraph[end].add(new Edge(start, weight));
        }
//        for(int k = 0; k < N + 1; k++){
//            System.out.println(k + " " +graph[k].toString());
//        }
        int[] dist1 = dijkstra(graph);
        int[] dist2 = dijkstra(reverseGraph);
        int ans = 0;
        for(int i = 1; i <= N; i ++){
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        System.out.println(ans);
    }

    private static int[] dijkstra(ArrayList<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(X, 0));
        visited = new boolean[N + 1];
        int dist[] = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            if (visited[cur.e]) continue;
            for(Edge vertex : graph[cur.e]){
                if (visited[vertex.e]) continue;
                if (dist[vertex.e] <= dist[cur.e] + vertex.w) continue;
                dist[vertex.e] = dist[cur.e] + vertex.w;
                pq.offer(new Edge(vertex.e, dist[vertex.e]));
            }
        }
//        System.out.println(Arrays.toString(dist));
        return dist;
    }
}
