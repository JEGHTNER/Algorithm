import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static int[][] arr;
	static boolean[] visited;
	static int chickenCnt;
	static int houseCnt;
	static int[] indexes;
	static ArrayList<int []> chickenCoord = new ArrayList<>();
	static ArrayList<int []> house = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 2) {
					chickenCoord.add(new int[] {i, j});
					chickenCnt++;
				}else if (tmp == 1) {
					house.add(new int[] {i, j});
					houseCnt++;
				}
				arr[i][j] = tmp;
			}
		}
		
		visited = new boolean[chickenCnt];
		indexes = new int[M];
		combi(0, 0);
		System.out.println(ans);
	}
	static int calcDistance(int r1, int c1, int r2, int c2) {
//		System.out.println("r1 = " + r1 + " r2 = " + r2 + " c1 = " + c1 + " c2 = " + c2 + " ret = " + (Math.abs(r1 - r2) + Math.abs(c1 - c2)));
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	static void combi(int depth, int start) {
		
		if (depth == M) {
//			System.out.println(Arrays.toString(indexes));
			int sum = 0;
			for (int i = 0; i < houseCnt; i++) {
//				int sum = 0;
				int minTmp = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					minTmp = Math.min(minTmp, calcDistance(house.get(i)[0], house.get(i)[1], chickenCoord.get(indexes[j])[0], chickenCoord.get(indexes[j])[1]));
//					sum += calcDistance(house.get(i)[0], house.get(i)[1], chickenCoord.get(indexes[j])[0], chickenCoord.get(indexes[j])[1]);	
//					System.out.println(sum);
				}
				sum += minTmp;
				
			}
			ans = Math.min(ans, sum);
			return ;
		}
		for (int i = start; i < chickenCnt; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			indexes[depth] = i;
			combi(depth + 1, i + 1);
			visited[i] = false;
		}
	}
}
