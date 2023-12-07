import java.util.*;

    
class Solution{
    static int[] answer;
    static ArrayList<String>[] strs, revStrs;
    public int[] solution(String[] words, String[] queries) {
        answer = new int[queries.length];
        strs = new ArrayList[10001];
        revStrs = new ArrayList[10001];
        int listIdx = 0;
        for (int i = 0; i < 10001; i++){
            strs[i] = new ArrayList<>();
            revStrs[i] = new ArrayList<>();
        }
        for (String w : words){
            listIdx = w.length();
            strs[listIdx].add(w);
            StringBuilder sb = new StringBuilder(w);
            revStrs[listIdx].add(sb.reverse().toString());
        }
        // for (int k = 0; k < 10; k++){
            // System.out.println(strs[k]);
            // System.out.println(revStrs[k]);
        // }
        for(int i = 0; i < 10001; i++){
            Collections.sort(strs[i]);
            Collections.sort(revStrs[i]);
        }
        int i = 0;
        for (String query : queries){
            answer[i++] = check(query);
        }
        return answer;
    }
    public static int check(String query){
        int queryLength = query.length();
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        //make binary search start, end
        for (int i = 0; i < queryLength; i++){
            if(query.charAt(i) !='?'){
                start.append(query.charAt(i));
                end.append(query.charAt(i));
            }else{
                start.append('a');
                end.append('z');
            }
        }
        if (query.charAt(0) == '?'){
            start.reverse();
            end.reverse();
            return Collections.binarySearch(revStrs[queryLength], start.toString()) -Collections.binarySearch(revStrs[queryLength], end.toString());
        }
    return Collections.binarySearch(strs[queryLength], start.toString()) -Collections.binarySearch(strs[queryLength], end.toString());
        // System.out.println(start + " " + end);
        // System.out.println(Collections.binarySearch(strs[queryLength], start.toString()));
        // System.out.println(Collections.binarySearch(strs[queryLength], end.toString()));
        // return 0;
    }
}

// class Solution {
//     static int[] answer;
//     public int[] solution(String[] words, String[] queries) {
//         answer = new int[queries.length];
//         int i = 0;
//         for(String query : queries){
//             answer[i++] = check(query, words);
//         }
//         return answer;
//     }
    
//     public int check(String query, String[] words){
//         StringBuilder search = new StringBuilder();
//         int wordLength = query.length();
        
//         for(int i = 0; i < wordLength; i++){
//             char s = query.charAt(i);
//             if (s!='?') search.append(s);
//         }
//         // System.out.println(search);
//         int count = 0;
//         //?가 앞에있을때
//         if (query.charAt(0) == '?'){
//             for(String word : words){
//                 if (word.endsWith(search.toString()) && word.length() == wordLength) count++;
//             }
//         }else{ // ?가 뒤에있을때
//             for(String word: words){
//                 if (word.startsWith(search.toString()) && word.length() == wordLength) count++;
//             }
//         }
//         return count;
//     }
    
// }
