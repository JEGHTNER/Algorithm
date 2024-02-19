import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> answer = new ArrayList<>();
    static int size;
    public String[] solution(String[][] tickets) {
        size = tickets.length;
        visited = new boolean[size];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    public void dfs(int depth, String from, String path, String[][] tickets){
        if(depth == size){
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