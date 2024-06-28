import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static class Edge implements Comparable<Edge>{
        int e;
        int w;

        public Edge(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public String toString(){
            return "e = " + e + " w = " + w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int N,M, first,last;
    static ArrayList<Edge> graph[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(e,w);
            graph[s].add(edge);
        }
        st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        last = Integer.parseInt(st.nextToken());
//        for(int k = 0; k < N; k++)
//            System.out.println(k + " " + graph[k]);
        System.out.println(dik());
    }
    public static int dik(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int distance[] = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[first] = 0;
        pq.offer(new Edge(first,0));
        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visited[cur.e]) continue;
            visited[cur.e] = true;
            for(Edge next : graph[cur.e]){
                if(visited[next.e]) continue;
                if(distance[next.e] <= distance[cur.e] + next.w) continue;
                distance[next.e] = distance[cur.e] + next.w;
                pq.add(new Edge(next.e, distance[next.e]));
            }
        }
//        System.out.println(Arrays.toString(distance));
        return distance[last];
    }
}
