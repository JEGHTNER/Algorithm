import java.io.*;
import java.util.*;

public class Main {

    static int n, m, S, T;
    static ArrayList<Integer>[] graph, rGraph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        rGraph = new ArrayList[n + 1];
        
        for(int i = 0; i < n + 1; i++){
            graph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            rGraph[y].add(x);
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // for(int k = 0; k < n + 1; k++){
        //     System.out.println(k + " " + graph[k]);
        // }
        // for(int k = 0; k < n + 1; k++){
        //     System.out.println(k + " " + rGraph[k]);
        // }
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        dfs(S, T, graph, s1, new boolean[n + 1]);
        dfs(T, -1, rGraph, s2, new boolean[n + 1]);
        // System.out.println(s1 +" " + s2);
        s1.retainAll(s2);
        
        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();
        dfs(T, S, graph,s3, new boolean[n + 1]);
        dfs(S, -1, rGraph, s4, new boolean[n+1]);
        // System.out.println(s3 + " " + s4);
        s3.retainAll(s4);
        s1.retainAll(s3);
        
        // System.out.println(s1);
        int answer = s1.size();
        if(s1.contains(S)) answer--;
        if(s1.contains(T)) answer--;
        System.out.println(answer);
    }
    public static void dfs(int node, int stop, ArrayList<Integer>graph[], Set<Integer> set, boolean[] visited){
        if(stop != -1 && node == stop){
            return;
        }
        for(Integer i : graph[node]){
            int next = i;
            if(visited[next]) continue;
            visited[node] = true;
            set.add(next);
            dfs(next, stop, graph, set, visited);
        }
        return;
    }
}
