import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M;
    static String[] first, second;
    static HashMap<String, Integer> hashMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            hashMap = new HashMap<>();
            first = new String[N];
            second = new String[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String input = st.nextToken();
                if (hashMap.containsKey(input)) {
                    hashMap.put(input, hashMap.get(input) + 1);
                    cnt++;
                }
                else hashMap.put(input, 1);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String input = st.nextToken();
                if (hashMap.containsKey(input)) {
                    hashMap.put(input, hashMap.get(input) + 1);
                    cnt++;
                }
                else hashMap.put(input, 1);
            }

            System.out.println("#"+tc+" "+cnt);
        }
    }
}
