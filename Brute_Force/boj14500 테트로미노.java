import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static int[][] square1_dr = { {0, 0, 0, 0}, {0, 1, 2, 3} };
    static int[][] square1_dc = { {0, 1, 2, 3}, {0, 0, 0, 0} };
    static int[][] square2_dr = { {0, 1, 0, 1}};
    static int[][] square2_dc = { {0, 0, 1, 1}};
    static int[][] square3_dr = { {0, 1, 2, 2}, {0, 1, 0, 0}, {0, 0, 1, 2}, {0, 1, 1, 1}, {0, 1, 2, 2}, {0, 1, 1, 1}, {0, 1, 2, 0}, {0, 0, 0, 1} };
    static int[][] square3_dc = { {0, 0, 0, 1}, {0, 0, 1, 2}, {0, 1, 1, 1}, {0, 0, -1, -2}, {0, 0, 0, -1}, {0, 0, 1, 2}, {0, 0, 0, 1}, {0, 1, 2, 2}};
    static int[][] square4_dr = { {0, 1, 1, 2}, {0, 0, 1, 1}, {0, 1, 1, 2}, {0, 0, 1, 1}};
    static int[][] square4_dc = { {0, 0, 1, 1}, {0, 1, 0 ,-1}, {0, 0 ,-1, -1}, {0, 1, 1, 2}};
    static int[][] square5_dr = { {0, 0, 1, 0}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 1, 1}};
    static int[][] square5_dc = { {0, 1, 1, 2}, {0, 0, -1, 0}, {0, 0, 1, 0}, {0, 0, -1, 1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check(i, j);
            }
        }
        System.out.println(max);
    }
    static void check(int i, int j){
        int sum = 0;
        square1(i, j);
        square2(i, j);
        square3(i, j);
        square4(i, j);
        square5(i, j);
    }
    static void square1(int i, int j) {
        int sum = 0;
        for (int idx = 0; idx < 2; idx++) { // square1;
            sum = 0;
            for (int k = 0; k < 4; k++) {
                int nr = square1_dr[idx][k] + i;
                int nc = square1_dc[idx][k] + j;
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    sum = 0;
                    break;
                }
                sum += arr[nr][nc];
            }
//            if (sum > max) {
//                System.out.println("i = " + i + " j = " + j + " sum = " + sum);
                max = Math.max(sum, max);
//            }
        }
    }
    static void square2(int i, int j) {
        int sum = 0;
        for (int idx = 0; idx < 1; idx++) { // square2;
            sum = 0;
            for (int k = 0; k < 4; k++) {
                int nr = square2_dr[idx][k] + i;
                int nc = square2_dc[idx][k] + j;
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    sum = 0;
                    break;
                }
                sum += arr[nr][nc];
            }
//            if (sum > max) {
//                System.out.println("i = " + i + " j = " + j + " sum = " + sum);
            max = Math.max(sum, max);
//            }
        }
    }
    static void square3(int i, int j) {
        int sum = 0;
        for (int idx = 0; idx < 8; idx++) { // square1;
            sum = 0;
            for (int k = 0; k < 4; k++) {
                int nr = square3_dr[idx][k] + i;
                int nc = square3_dc[idx][k] + j;
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    sum = 0;
                    break;
                }
                sum += arr[nr][nc];
            }
//            if (sum > max) {
//                System.out.println("i = " + i + " j = " + j +" idx= "+idx+  " sum = " + sum);
            max = Math.max(sum, max);
//            }
        }
    }
    static void square4(int i, int j) {
        int sum = 0;
        for (int idx = 0; idx < 4; idx++) { // square1;
            sum = 0;
            for (int k = 0; k < 4; k++) {
                int nr = square4_dr[idx][k] + i;
                int nc = square4_dc[idx][k] + j;
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    sum = 0;
                    break;
                }
                sum += arr[nr][nc];
            }
//            if (sum > max) {
//                System.out.println("i = " + i + " j = " + j + " sum = " + sum);
            max = Math.max(sum, max);
//            }
        }
    }
    static void square5(int i, int j) {
        int sum = 0;
        for (int idx = 0; idx < 4; idx++) { // square1;
            sum = 0;
            for (int k = 0; k < 4; k++) {
                int nr = square5_dr[idx][k] + i;
                int nc = square5_dc[idx][k] + j;
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    sum = 0;
                    break;
                }
                sum += arr[nr][nc];
            }
//            if (sum > max) {
//                System.out.println("i = " + i + " j = " + j + " sum = " + sum);
            max = Math.max(sum, max);
//            }
        }
    }
}
