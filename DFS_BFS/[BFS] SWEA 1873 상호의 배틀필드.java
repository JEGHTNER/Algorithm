import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int T, H, W, N;
	static char[][] arr;
	static String cmd;
	static int tr, tc;
	static char dir;
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; //상 우 하 좌
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			arr = new char[H][W];
			for (int i = 0; i < H; i++) {
				char[] input = sc.next().toCharArray();
				for (int j = 0; j < W; j++) {
					arr[i][j] = input[j];
					if (input[j] == '^' || input[j] == '>' ||input[j] ==  'v' ||input[j] == '<') {
						tr = i; tc = j; dir = input[j];
					}
				}
			}
			N = sc.nextInt();
			cmd = sc.next();
			bfs(tr,tc);
			System.out.print("#" +t+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}System.out.println();
			}
		}
	}
	static void bfs(int i, int j) {
		for (int k = 0; k < N; k++) {
			char c = cmd.charAt(k);
//			System.out.println(c);
//			for (int l = 0; l < H; l++) {
//				System.out.println(Arrays.toString(arr[l]));
//			}System.out.println();
			if (c == 'S') {
				shoot(tr, tc);
			}else if (c == 'U') {
					dir = '^';
					arr[tr][tc] = dir;
					int nr = tr + dr[0];
					int nc = tc + dc[0];
					if (!check(nr, nc) || arr[nr][nc] !='.') continue;
					arr[tr][tc] = '.';
					arr[nr][nc] = '^';
					tr = nr;
					tc = nc;
				}else if (c == 'R') {
					dir = '>';
					arr[tr][tc] = dir;
					int nr = tr + dr[1];
					int nc = tc + dc[1];
					if (!check(nr, nc)|| arr[nr][nc] !='.') continue;
					arr[tr][tc] = '.';
					arr[nr][nc] = '>';
					tr = nr;
					tc = nc;
				}
				else if (c == 'D') {
					dir = 'v';
					arr[tr][tc] = dir;
					int nr = tr + dr[2];
					int nc = tc + dc[2];
					if (!check(nr, nc)|| arr[nr][nc] !='.') continue;
					arr[tr][tc] = '.';
					arr[nr][nc] = 'v';
					tr = nr;
					tc = nc;
				}else if (c == 'L') {
					dir = '<';
					arr[tr][tc] = dir;
					int nr = tr + dr[3];
					int nc = tc + dc[3];
					if (!check(nr, nc)|| arr[nr][nc] !='.') continue;
					arr[tr][tc] = '.';
					arr[nr][nc] = '<';
					tr = nr;
					tc = nc;
				}
			}
		}
	private static void shoot(int tr, int tc) {
		int d = 0;
		if (dir == '^') d = 0;
		else if (dir == '>') d = 1;
		else if (dir == 'v') d = 2;
		else if (dir == '<') d = 3;
		int r = tr;
		int c = tc;
		while(true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc)) break;
			if (arr[nr][nc] == '#') break;
			if (arr[nr][nc] == '*') {
				arr[nr][nc] = '.';
				break;
			}
			r = nr;
			c = nc;
		}
		
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= H || nc >= W) return false;
		return true;
	}
}
