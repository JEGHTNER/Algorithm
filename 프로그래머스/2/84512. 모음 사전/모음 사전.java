import java.util.*;

class Solution {
    static String alph = "AEIOU";
    static int answer;
    static int count = -1;
    public int solution(String word) {
        dfs(0, word, "");
        return answer;
    }
    public void dfs(int depth, String word, String path){
        count++;
        // System.out.println(path + " " + count + " " + path.equals(word));
        if (path.equals(word)) {
            answer = count;
            return;
        }
        if (depth == 5) return;
        for (int i = 0; i < 5; i++){
            dfs(depth + 1, word, path + alph.charAt(i));
        }
    }
}
