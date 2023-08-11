import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int arr[][];
	static int dr[] = {1, 0, -1, 0}; // 하 우 상 좌
	static int dc[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(1, N, 1, M);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
		static void move(int r1, int r2, int c1, int c2) {
			if(r1>r2 | c1>c2) return;
			int r = R%(2*(r2-r1+c2-c1));
			while(r-->0) {
				int end = arr[r1][c1];
				for(int i = c1; i < c2; i++) {
					arr[r1][i] = arr[r1][i+1];
				}
				for(int i = r1; i < r2; i++) {
					arr[i][c2] = arr[i+1][c2];
				}
				for(int i = c2; i > c1; i--) {
					arr[r2][i] = arr[r2][i-1];
				}
				for(int i = r2; i > r1; i--) {
					arr[i][c1] = arr[i-1][c1];
				}
				arr[r1+1][c1] = end;
			}
			
			move(r1+1, r2-1, c1+1, c2-1);
		}
}
