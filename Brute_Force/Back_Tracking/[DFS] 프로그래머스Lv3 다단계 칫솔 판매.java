import java.util.*;

class Solution {
    static class Person{
        String name;
        Person parent;
        int idx;
        
        public Person(String name, int idx){
            this.name = name;
            this.parent = null;
            this.idx = idx;
        }
    }
    static HashMap<String, Person> dic;
    static int[] results;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        dic = new HashMap<>();
        int len = enroll.length;
        for(int i = 0; i < len; i++){
            dic.put(enroll[i], new Person(enroll[i], i));
        }
        
        // for(String s : enroll){
        //     if (dic.containsKey(s)) continue;
        //     dic.put(s, hash++);
        // }

        results = new int[len];
        // System.out.println(dic);
        for(int i = 0; i < len; i++){
            if (String.valueOf(referral[i].charAt(0)).equals("-")) continue;
            Person to = dic.get(referral[i]);
            Person from = dic.get(enroll[i]);
            from.parent = to;
        }
        // for(int i = 0; i < len; i++)
        // System.out.println(i + " " + graph[i]);
        int sLen = seller.length;
        for(int i = 0; i < sLen; i++)
        {
            Person start = dic.get(seller[i]);
            int price = amount[i] * 100;
            // bfs(start, price);
            dfs(start, price);
        }
        int[] answer = {};
        return results;
    }
    static void dfs(Person start, int price){
        int provide = price / 10;
        results[start.idx] += (price - provide);
        if (start.parent == null) return ;
        Person next = start.parent;
        dfs(next, provide);
    }
}
