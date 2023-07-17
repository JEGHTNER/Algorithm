package startcamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class main {
	static int map[][];
	static int N;
	static int r, c;
	static int T;
	static int dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
	static int d;
	
	static boolean check(int r, int c) {
		return r >=0 && r < N && c >= 0 && c < N;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <=T; tc++)
		{
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			r = 0; 
			c = 0;
			d = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
				{
					cnt++;
					map[r][c] = cnt;
					int nr = dr[d] + r;
					int nc = dc[d] + c;
					if ( !check(nr, nc) || map[nr][nc] != 0)
					{
						d = (d + 1) % 4;
						nr = dr[d] + r;
						nc = dc[d] + c;
					}
					r = nr;
					c = nc;
				}
			}
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++)
			{
				for (int j =0; j < N; j++)
					sb.append(map[i][j] + " ");
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}
}
