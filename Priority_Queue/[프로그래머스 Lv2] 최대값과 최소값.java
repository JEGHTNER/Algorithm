import java.util.*;

class Solution {
    public String solution(String s) {
        TreeSet<Integer> ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            ts.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(ts.first() + " " + ts.last());
        String answer = "";
        answer = answer + ts.first() + " " + ts.last();
        return answer;
    }
}
