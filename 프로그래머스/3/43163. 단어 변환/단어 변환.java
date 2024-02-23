import java.util.*;

class Solution {
    static int answer;
    static ArrayList<String> graph[];
    static boolean visited[];
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String begin, String target, String[] words) {

        // 타겟 단어 가능한 단어인지 체크
        if (!checkTarget(target, words)) return 0;
        // 한 글자만 다른 단어 선별
        int size = words.length;
        graph = new ArrayList[size + 1];
        visited = new boolean[size + 1];
        for(int i = 0; i < size; i++){
            map.put(words[i], i);
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < size; i++){
            int from = map.get(words[i]);
            for(int j = 0; j < size; j++){
                if(!checkAvailableWord(words[i], words[j])) continue;
                graph[from].add(words[j]);
            }
        }
        // for(int k = 0; k < size; k++){
        //     System.out.println(words[k] + " " + graph[map.get(words[k])].toString());
        // }
        bfs(begin, target, words);
        return answer;
    }
    public boolean checkTarget(String target, String[] words){
        for(String word: words){
            if(target.equals(word)) return true;
        }
        return false;
    }
    public boolean checkAvailableWord(String word, String word2){
        /*글자 수가 다른 개수 세기*/
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != word2.charAt(i)) count++;
        }
        if(count == 1) return true;
        return false;
    }
    public void bfs(String begin, String target, String[] words){
        Queue<String> queue = new ArrayDeque<>();
        for(String word : words){
            if(!checkAvailableWord(begin, word)) continue;
            queue.offer(word);
            visited[map.get(word)] = true;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println(size);
            answer++;
            while(size-- > 0){
                String cur = queue.poll();
                //찾음
                if (cur.equals(target))
                    return ;
                for(String next : graph[map.get(cur)]){
                    if(visited[map.get(next)]) continue;
                    visited[map.get(next)] = true;
                    queue.offer(next);
                }
            }
        }
    }
}