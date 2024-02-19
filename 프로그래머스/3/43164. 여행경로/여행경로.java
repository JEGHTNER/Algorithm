import java.util.*;

class Solution {
static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> graph[] = new ArrayList[10001];
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();
    static int size;
    public String[] solution(String[][] tickets) {
        size = tickets.length;
        visited = new boolean[size];

        dfs(0, "ICN", "ICN", tickets);
        // System.out.println(answer);
        Collections.sort(answer);
        // System.out.println(answer);
        return answer.get(0).split(" ");
    }

    public void dfs(int depth, String from, String path, String[][] tickets){
        if(depth == size){
            // System.out.println(path);
            answer.add(path);
            return ;
        }
        for(int i = 0; i < size; i++){
            if(visited[i]) continue;
            if(!from.equals(tickets[i][0])) continue;
            visited[i] = true;
            dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
            visited[i] = false;
        }
    }
}