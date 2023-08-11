import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int [][] hitter;
	static int M = 9;
	static int [] p = {2,3,4,5,6,7,8,9};
	static int max;
	static int base[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		hitter = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				hitter[i][j] = sc.nextInt();
			}
		}
		max = -1;
		do {
			int []player = new int[M];
			for (int i = 0; i < M; i++) {
				if (i < 3) {
					player[i] = p[i];
				}else if (i == 3) {
					player[i] = 1;
				}else if (i >= 4) {
					player[i] = p[i - 1];
				}
			}
			int score = 0;
			int j = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
//				System.out.println((i+1)+"이닝");
				int out = 0;
//				base = new int[5];
				int base1 = 0, base2 = 0, base3 = 0;
				for (; ; j++) {
					int hit = hitter[i][player[j % 9] - 1];
//					System.out.println( (j + 1)+"번 "+hit);
					if (hit == 0) {
						out++;
						if (out == 3) {
							j++;
							break;
						}
						continue;
					}
					else if (hit == 1) {
						score += base3;
						base3 = base2;
						base2 = base1;
						base1 = 1;
					}else if (hit == 2) {
						score += base3 + base2;
						base3 = base1;
						base2 = 1;
						base1 = 0;
					}else if (hit == 3) {
						score += base3 + base2 + base1;
						base3 = 1;
						base2 = 0;
						base1 = 0;
					}else if (hit == 4) {
						score += base3 + base2 + base1 + 1;
						base3 = 0;
						base2 = 0;
						base1 = 0;
					}
				}
			}
			max = Math.max(max, score);
//			System.out.println(Arrays.toString(player));
//			System.out.println(score);
//			System.out.println(Arrays.toString(player));
//			System.out.println(Integer.toBinaryString(base));
//			System.out.println(max);
//			System.out.println(Integer.toBinaryString(max));
		}while (np(p));
		System.out.println(max);
	}
	private static boolean np(int[] p) { // p : 다음 순열을 원하는 기존 순열의 배열
		// 1. 맨 뒤쪽부터 탐색하며 꼭대기 찾기
		int N = p.length;
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i]) --i;
		
		if (i == 0) return false; // 다음 순열은 없음(가장 큰 순열의 형태)
		
		//2. 꼭대기 직전(i - 1) 위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
		int j = N - 1;
		while (p[i - 1] >= p[j]) --j;

		//3. 꼭대기 직전(i - 1)위치의 수와 한단계 큰 수를 교환하기
		swap(p, i - 1, j);
		
		//4. 꼭대기 자리부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
		int k = N - 1;
		while (i < k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}
}
