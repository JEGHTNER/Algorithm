import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class boj2023 {

	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		dfs(0, 0);
	}
	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= (int)Math.sqrt(n); i++){
			if (n % i == 0) {return false; }	
		}
		return true;
	}

	static void dfs(int depth, int num) {
		if (depth == N) {
			System.out.println(num);
			return ;
		}
		for (int i = 1; i < 10; i++) {
			if (i != 2 && i % 2 == 0) continue;
			if (isPrime(num * 10 + i) == false) continue;
			dfs(depth + 1, num * 10 + i);
		}
	}
}
