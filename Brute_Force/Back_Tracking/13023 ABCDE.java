import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int N, M, a, b;

    public static void dfs(int i, int depth){
        visited[i] = 1;
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for(int g : graph.get(i)){
            if (visited[g] != 0)
                continue;
            dfs(g, depth + 1);
            visited[g] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < N; i++)
        {
            dfs(i, 0);
            visited[i] = 0;
        }
        System.out.println(0);
    }
}
