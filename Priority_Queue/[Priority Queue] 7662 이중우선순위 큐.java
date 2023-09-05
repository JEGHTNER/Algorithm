package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class boj7662 {

	static int T, k;
	static TreeMap<Integer, Integer> tm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			tm = new TreeMap<>();
			k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (cmd.equals("I")) {
					if (tm.containsKey(num))
						tm.put(num, tm.get(num) + 1);
					else 
						tm.put(num, 1);
				} else if (cmd.equals("D")) {
					if (tm.isEmpty())
						continue;
					if (num == -1) { // 최소제거
						int min = tm.firstKey();
						tm.put(min, tm.get(min) - 1);
						if (tm.get(min) == 0) tm.remove(min);
					} else if (num == 1) {
						int max = tm.lastKey();
						tm.put(max, tm.get(max) - 1);
						if (tm.get(max) == 0) tm.remove(max);
					}
				}
			}
			if (tm.isEmpty())
				System.out.println("EMPTY");
			else {
				System.out.print(tm.lastKey() + " ");
				System.out.println(tm.firstKey());
			}
		}
	}
}
