package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea4013 {

    static int T, K;
    static int[][] arr;
    static int[] idxs;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int t_num = 0, dir = 0;
            arr = new int[4][8];
            idxs = new int[4];

            K = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                t_num = Integer.parseInt(st.nextToken()) - 1;
                dir = Integer.parseInt(st.nextToken());
                // 회전
//                System.out.println(i);
                visited = new boolean[4];
                circle(t_num, dir);
            }
            // 0번 (0,2) <-> (1,6) 1번 (1,2) <-> (2,6) 2번 (2,2) <-> (3,6)
//            System.out.println(Arrays.toString(idxs));
            int ans = 0;
//            for (int i = 0; i < 4; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }System.out.println();
            for (int i = 0; i < 4; i++) {
                int newIdx = getIdx(i, 0);
//                if (idxs[i] >= 0) newIdx = (Math.abs(8 - idxs[i])) % 8;
//                System.out.println(Math.pow(2, i) + " * " + arr[i][newIdx] + " newidx =" + newIdx);
                ans += (int) Math.pow(2, i) * (arr[i][newIdx]);
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    static public void circle(int t_num, int dir) {// t_num 톱니 dir 방향
//        System.out.println("circle t_num = " + t_num);
//        System.out.println(Arrays.toString(visited));

        if (visited[t_num]) return ;
        visited[t_num] = true;
        // 1번 4번
        if (t_num == 0 || t_num == 3) {
            if (t_num == 0) {
                // 맞물려 있는 자석이 상극이라면 같이 회전
                if (arr[0][getIdx(0, 2)] != arr[1][getIdx(1, 6)]) {
//					idxs[1] += (dir * -1);
                    circle(1, dir * -1);
                }
            } else if (t_num == 3) {
                if (arr[3][getIdx(3, 6)] != arr[2][getIdx(2,2)]) {
//					idxs[2] += (dir * -1);
                    circle(2, dir * -1);
                }
            }
            // 2번 3번
        } else if (t_num == 1 || t_num == 2) {
            if (t_num == 1) {
                // 맞물려 있는 자석이 상극이라면 같이 회전
                if (arr[1][getIdx(1,2)] != arr[2][getIdx(2,6)]) {
//					idxs[2] += (dir * -1);
                    circle(2, dir * -1);
                }
                if (arr[1][getIdx(1,6)] != arr[0][getIdx(0,2)]) {
//					idxs[0] += (dir * -1);
                    circle(0, dir * -1);
                }
            } else if (t_num == 2) {
                if (arr[2][getIdx(2,2)] != arr[3][getIdx(3,6)]) {
//					idxs[3] += (dir * -1);
                    circle(3, dir * -1);
                }
                if (arr[2][getIdx(2,6)] != arr[1][getIdx(1,2)]) {
//					idxs[1] += (dir * -1);
                    circle(1, dir * -1);

                }
            }
        }
        idxs[t_num] += dir;
    }
    static public int getIdx(int i, int j) {
        int idx = 0;
        
//        System.out.println(Arrays.toString(idxs));
        idx = Math.abs(j - idxs[i] + 8) % 8;
//        if (idxs[i] > 0) {
//        	idx = Math.abs(j - idxs[i] + 8) % 8;
//        }else {
//        	idx = Math.abs(j - idxs[i] + 8) % 8;
//        }
//        if (idxs[i] < 0) {
//            idx = ( (j + idxs[i] * -1) % 8);
//        }else{
//            if (j + idxs[i] < 0) idx = (Math.abs(8 - (j - idxs[i]))) % 8;
//            else idx = (j + idxs[i]) % 8;
//        }
//        System.out.println("i = " + i + " j = "+ j + " idx = " + idx + " compare=" + arr[i][idx]);
//        for (int k = 0; k < 4; k++) {
//            System.out.println(Arrays.toString(arr[k]));
//        }System.out.println();
        return idx;
    }
}
