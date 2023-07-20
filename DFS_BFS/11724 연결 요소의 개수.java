import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int N, M, u, v, ans;
    static int[] visited;

    public static void bfs(int i){
        if (visited[i] != 0)
            return ;
        ans += 1;
        Queue queue = new LinkedList();
        queue.add(i);
        visited[i] = 1;
        while (queue.size() != 0) {
            int tmp = (int) queue.poll();
            for (int num : graph.get(tmp)) {
                if (visited[num] != 0) continue;
                visited[num] = 1;
                queue.add(num);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
//        System.out.println(graph);
        for (int i = 1; i < N + 1; i++)
            bfs(i);
        System.out.println(ans);
    }
}
