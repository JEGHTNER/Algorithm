import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1504 {
    static class Edge implements Comparable<Edge>{
        int num;
        int weight;

        public Edge(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "num=" + num +
                    ", weight=" + weight +
                    '}';
        }
    }
    static int N, E, u, v, ans, ans1, ans2;
    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, weight));
            graph[end].add(new Edge(start,weight));
        }
//        for (int i = 0; i < N + 1; i++) {
//            System.out.println(i+" "+graph[i].toString());
//        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int distance[] = dijkstra(1);
        int distance2[] = dijkstra(u);
        int distance3[] = dijkstra(v);
//        System.out.println(Arrays.toString(distance));
//        System.out.println(Arrays.toString(distance2));
//        System.out.println(Arrays.toString(distance3));
        if (distance[v] == Integer.MAX_VALUE || distance3[u] == Integer.MAX_VALUE || distance2[N] == Integer.MAX_VALUE)
            ans1 = -1;
        else {
            if (distance[v] != Integer.MAX_VALUE) ans1 += distance[v];
            if (distance3[u] != Integer.MAX_VALUE) ans1 += distance3[u];
            if (distance2[N] != Integer.MAX_VALUE) ans1 += distance2[N];
        }

        if (distance[u] == Integer.MAX_VALUE || distance2[v] == Integer.MAX_VALUE || distance3[N] == Integer.MAX_VALUE)
            ans2 = -1;
        else {
            if (distance[u] != Integer.MAX_VALUE) ans2 += distance[u];
            if (distance2[v] != Integer.MAX_VALUE) ans2 += distance2[v];
            if (distance3[N] != Integer.MAX_VALUE) ans2 += distance3[N];
        }

        if (ans1 == -1 && ans2 == -1) System.out.println(-1);
        else{
            ans = Math.min(ans1, ans2);
            System.out.println(ans);
        }

    }
    static int[] dijkstra(int start){
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int v = cur.num;
//            visited[v] = true;
            for(Edge next : graph[v]){
                if (visited[next.num]) continue;
                if (distance[next.num] <= distance[v] + next.weight) continue;
                distance[next.num] = distance[v] + next.weight;
                pq.offer(new Edge(next.num, distance[next.num]));
            }
        }
        return distance;
    }
}
