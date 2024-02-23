import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int size = works.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.offer(work);
        }
        for(int i = 0; i < n; i++){
            int num = pq.poll();
            pq.offer(num-1);
        }
        
        for(int num : pq){
            // System.out.print(num + " ");
            if (num <= 0) continue;
            answer += num * num;
        }
        return answer;
    }
}