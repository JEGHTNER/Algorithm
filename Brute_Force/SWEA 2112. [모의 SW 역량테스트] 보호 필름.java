
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int T, D, W, K, stop;
    static int[][] arr;
    static boolean[] visited, subVisited;
    static int[] nums, A, B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[D][W];
            stop = 0;
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 0) input = -1;
                    arr[i][j] = input;
                }
            }
            int ans = 0;
            if (check(1)) {
                System.out.println("#"+tc+" " + ans);
            }else {
                for (int i = 0; i < D; i++) { // 조합 개수 몇개 주입할건지
                    visited = new boolean[D];
                    nums = new int[i + 1];
                    comb(0, i + 1, 0);
                    if (stop == 1) {
                        ans = i + 1;
                        break;
                    }
                }
                System.out.println("#"+tc+" " + ans);
            }
        }
    }
    public static void comb(int depth, int len, int start) {
        if (stop == 1) return ;
        if (depth == len) { // 주입 개수만큼
//			System.out.println(Arrays.toString(nums));
            subVisited = new boolean[len];
            generateSubSet(0, len);
            return;
        }
        for (int i = start; i < D; i++) {
            if (visited[depth]) continue;
            visited[depth] = true;
            nums[depth] = i;
            comb(depth + 1, len, i + 1);
            visited[depth] = false;
        }
    }

    private static void generateSubSet(int depth, int len) {
        if (stop == 1) return ;
        if (depth == len) {
            int aCnt = 0, bCnt = 0;
            for (int i = 0; i < len; i++) {
                if (subVisited[i]) {
                    aCnt++;
                }else {
                    bCnt++;
                }
            }
            A = new int[aCnt];
            B = new int[bCnt];
            aCnt = 0;
            bCnt = 0;
            for (int i = 0; i < len; i++) {
                if (subVisited[i]) {
                    A[aCnt++] = nums[i];
                }else {
                    B[bCnt++] = nums[i];
                }
            }
//			System.out.println("A= "+Arrays.toString(A) + " B=" + Arrays.toString(B));
            if (check(0)) {
                stop = 1;
            }
            return;
        }

        subVisited[depth] = true;
        generateSubSet(depth + 1, len);
        subVisited[depth] = false;
        generateSubSet(depth + 1, len);
    }
    public static boolean check(int first) {
        int flag = 0;

        int[][] temp = new int[D][W];
        if (first == 0) {
            for (int row : A) {
                temp[row] = arr[row].clone();
                Arrays.fill(arr[row], -1);
            }
            for (int row : B) {
                temp[row] = arr[row].clone();
                Arrays.fill(arr[row], 1);
            }
        }
//		for (int k = 0; k < D; k++) {
//			System.out.println(Arrays.toString(temp[k]));
//		}System.out.println();
        for (int i = 0; i < W; i++) {
//			System.out.println("i= "+i);
            for (int j = 0; j <= D - K; j++) {
                int sum = 0;
                for (int k = 0; k < K; k++) {
                    sum += arr[j + k][i];
                }
//				System.out.println("j = "+ j +  " sum = " + sum);
                if (sum == K || sum == -K) {

                    flag++;
                    break;
                }
            }
            if (flag != i+1) break;
        }
        if (first == 0) {
            for (int row : A) {
                arr[row] = temp[row].clone();
            }
            for (int row : B) {
                arr[row] = temp[row].clone();
            }
        }
        if (flag == W) return true;
        return false;
    }

    private static int find(int i) {
        for (int j = 0; j < A.length; j++) {
            if (i == A[j]) return 1;
        }
        for (int j = 0; j < B.length; j++) {
            if (i == B[j]) return 2;
        }
        return 0;
    }
}
