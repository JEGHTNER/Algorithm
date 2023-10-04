import java.util.*;

class Solution {
    static class p implements Comparable<p>{
        int index;
        int number;
        
        p(int index, int number){
            this.index = index;
            this.number = number;
        }
        public int compareTo(p o1){
            return -Integer.compare(this.number, o1.number);
        }
        public String toString(){
            return (index + " " + number);
        }
}
    public int[] solution(String[] genres, int[] plays){
        PriorityQueue<p> pq[] = new PriorityQueue[100];
        for(int i = 0; i < 100; i++){
            pq[i] = new PriorityQueue<>();
        }
        
        HashMap<String, Integer > dic = new HashMap<>();
        TreeMap<String, Integer > dic2 = new TreeMap<>();
        int len = genres.length;
        int j = 0;
        for(int i = 0; i < len; i++){
            if (dic.containsKey(genres[i])){
                dic.put(genres[i], dic.get(genres[i]) + plays[i]);
            }
            else {
                dic.put(genres[i], plays[i]);
                dic2.put(genres[i], j++);
            }
            pq[dic2.get(genres[i])].offer(new p(i, plays[i]));
        }
        List<String> keySet = new ArrayList<>(dic.keySet());
        keySet.sort( (o1, o2) -> dic.get(o2) - dic.get(o1));

        ArrayList<Integer> ans = new ArrayList<>();
        for(String key : keySet){
            for(int i = 0; i < 2; i++){
                if (!pq[dic2.get(key)].isEmpty())
                    ans.add(pq[dic2.get(key)].poll().index);
            }
        }
        // System.out.println(ans);
        int[] arr = ans.stream()
	    .mapToInt(Integer::intValue)
    	.toArray();
        return arr;
    }
}
