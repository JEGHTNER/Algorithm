import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int N, M, X;
    static ArrayList<Edge>[] graph, r_graph;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        r_graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            r_graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, weight));
            r_graph[end].add(new Edge(start, weight));
        }
//        for (int i = 0; i <= N; i++) {
//            System.out.println(i + " " +graph[i].toString());
//        }
//        System.out.println();
//        for (int i = 0; i <= N; i++) {
//            System.out.println(i+" "+ r_graph[i].toString());
//        }
        int[] dist1 = dijkstra(graph);
        int[] dist2 = dijkstra(r_graph);
//        System.out.println(Arrays.toString(dist1));
//        System.out.println(Arrays.toString(dist2));
        int ans = 0;
        for (int i = 0; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        System.out.println(ans);
    }

    private static int[] dijkstra(ArrayList<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue();
        pq.offer(new Edge(X, 0));
        visited = new boolean[N + 1];
        int dist[] = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            int nextVertex = tmp.vertex;
            if (visited[nextVertex]) continue;
            for (Edge v : graph[nextVertex]) {
                if (visited[v.vertex]) continue;
                if (dist[v.vertex] <= dist[nextVertex] + v.weight) continue;
                dist[v.vertex] = dist[nextVertex] + v.weight;
//                System.out.println(nextVertex +" "+ v.vertex+ " " + v.weight+ " " +Arrays.toString(dist));
                pq.offer(new Edge(v.vertex, dist[v.vertex]));
            }
        }
        return dist;
    }
}
