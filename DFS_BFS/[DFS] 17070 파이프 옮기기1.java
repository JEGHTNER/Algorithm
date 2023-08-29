import java.util.*;

public class boj17070 {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr0 = {0, 1}, dc0 = {1, 1}; // 0 : 가로 ,우 우하 1:대각선 우 하 우 2:세로 하 우하
    static int[] dr1 = {0, 1, 1}, dc1 = {1, 1, 0};
    static int[] dr2 = {1, 1}, dc2 = {0, 1};
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited[0][1] = true;
        dfs(0, 1, 0); // flag = 0 : 가로, 1 : 대각선, 2 : 세로
        System.out.println(cnt);
    }
    static void dfs(int r, int c, int flag){
        if (r == N - 1 && c == N - 1) {
            cnt++;
//            for (int k = 0; k < N; k++) {
//                System.out.println(Arrays.toString(visited[k]));
//            }
//            System.out.println();
            return ;
        }
        if (flag == 0){
            for (int d = 0; d < 2; d++) {
                int nr = r + dr0[d];
                int nc = c + dc0[d];
                int nflag = d % 2;
                if (!check(nr,nc)) continue;
                if (nflag == 1){
                    if (!checkFlag1(r, c)) continue;
                }
                if (arr[nr][nc] == 1) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dfs(nr, nc, nflag);
                visited[nr][nc] = false;
            }
        }else if (flag == 1){
//            if (!checkFlag1(r, c)) return ;
            for (int d = 0; d < 3; d++) {
                int nr = r + dr1[d];
                int nc = c + dc1[d];
                int nflag = d % 3;
                if (!check(nr,nc)) continue;
                if (nflag == 1){
                    if (!checkFlag1(r, c)) continue;
                }
                if (arr[nr][nc] == 1) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dfs(nr, nc, nflag);
                visited[nr][nc] = false;
            }
        }else if (flag == 2){
            for (int d = 0; d < 2; d++) {
                int nr = r + dr2[d];
                int nc = c + dc2[d];
                int nflag = 2 - d;
                if (!check(nr,nc)) continue;
                if (nflag == 1){
                    if (!checkFlag1(r, c)) continue;
                }
                if (arr[nr][nc] == 1) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dfs(nr, nc, nflag);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean checkFlag1(int r, int c) {
        for (int d = 0; d < 3; d++) {
            int nr = r + dr1[d];
            int nc = c + dc1[d];
            int nflag = d % 3;
            if (!check(nr, nc)) continue;
            if (arr[nr][nc] == 1) return false;
        }
        return true;
    }

    static boolean check(int nr, int nc){
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) return false;
        return true;
    }
}
