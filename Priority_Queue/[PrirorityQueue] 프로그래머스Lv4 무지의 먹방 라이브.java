import java.util.*;

class Solution {
    static class Food implements Comparable<Food>{
        int index;
        int times;
        
        public Food(int index, int times){
            this.index = index;
            this.times = times;
        }
        
        public int compareTo(Food o) {
            return this.times - o.times;
        }
        public String toString(){
            return "index=" + this.index + " times= " + this.times;
        }
    }
    static PriorityQueue<Food> pq = new PriorityQueue<>();
    static int food_len;
    public int solution(int[] food_times, long k) {
        int answer = 0;
        long food_sum = 0;
        food_len = food_times.length;
        for(int i = 0; i < food_len; i++){
           pq.offer(new Food(i, food_times[i]));
            food_sum += (long)food_times[i];
        }
        if (food_sum <= k) return -1;
        long total = 0;
        long time = 0;
        long last = 0;
        while(total + (pq.peek().times-last) * (food_len) <= k){
            // System.out.println(pq);
            int now = pq.poll().times;
            // System.out.print("k = " + k + " now = " + now + " last = " + last + " food_len = " + (food_len));
            total += (now-last) * (food_len);
            // System.out.println(" res = " + k);
            last = now;
            food_len-=1;
        }
        // System.out.println(idx + " " + k + " size= " + pq.size());
        // System.out.println(pq);
        ArrayList<Food> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result, new Comparator<Food>(){
            public int compare(Food a, Food b){
                return Integer.compare(a.index, b.index);
            }
        });
        answer = result.get((int)( (k -total)% food_len)).index+1;
        return answer;
    }
}
