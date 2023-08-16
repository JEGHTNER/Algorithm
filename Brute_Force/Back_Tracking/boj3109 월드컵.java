import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {

	static int R,C, cnt;
	static int arr[][];
	static int visited[][];
//	static boolean visited[][];
	static int dr[] = {-1, 0, 1};
	static int dc[] = {1, 1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new int[R][C];
//		visited = new boolean[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			String input = sc.next();
//			System.out.println(input);
			
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) =='.') {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
			}
		}
//		for (int j = 0; j < R; j++) {			
//			System.out.println(Arrays.toString(arr[j]));
//		}
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		System.out.println(cnt);
	}
	static void dfs(int i, int j) {
		int count = 1;
		Stack<int []> stack = new Stack<>();
		stack.add(new int[] {i, j});
//		visited[i][j] = true;
		visited[i][j] = count++;
		while(!stack.isEmpty()) {
			int[] temp = stack.pop();
			int r = temp[0], c = temp[1];
			for (int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
//					if (visited[nr][nc] || arr[nr][nc] == 1) continue;
					if (visited[nr][nc] > 0 || arr[nr][nc] == 1)continue;
					visited[nr][nc] = count++;
					arr[nr][nc] = 1;
					
					if (nc == C - 1) {
						cnt++;
						for (int k = 0; k < R; k++) {			
							System.out.println(Arrays.toString(arr[k]));
						}System.out.println();
						break;
					}
//					System.out.println(nr + " " + nc);
					stack.add(new int[] {nr, nc});

					for (int k = 0; k < R; k++) {			
						System.out.println(Arrays.toString(arr[k]));
					}System.out.println();
					break ;
			}
		}
	}
}
