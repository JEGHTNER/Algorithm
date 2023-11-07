import java.util.*;

class Solution {
    static HashMap<Long, Long> hm = new HashMap<>();
    public long find(long num){
        if (!hm.containsKey(num)) {
            hm.put(num, num + 1);
            return num;
        }
        long empty = find(hm.get(num));
        hm.put(num, empty);
        return (empty);
    }
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i = 0; i < room_number.length; i++){
            answer[i] = find(room_number[i]);
        }
            
        return answer;
        }
}

//             if(hm.containsKey(cur)){
//                 long find = cur;
//                 // System.out.println("cur = " + find + " " + hm.toString());
//                 while(hm.containsKey(find)){
//                     long temp = hm.get(find); // 1
//                     hm.put(find, hm.get(find) + 1);
//                     find = find + temp; // 4
//                     // System.out.println("find = " + find);
//                     if (!hm.containsKey(find)){
//                         // hm.put(find, hm.get(find) + 1);
//                         hm.put(find, 1);
//                         break;
//                     }
                    
//                 }
//                 answer[i] = find;
//             }else{
//                 hm.put(cur, 1);
//                 answer[i] = cur;
//             }
