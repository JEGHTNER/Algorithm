import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int R,C,T, ans;
    static int [][] arr;
    //바람방향 2개
    static int[] dr = { 0, 1, 0, -1}, dc = {1, 0, -1, 0}, tdr = {0, -1, 0, 1}, tdc = {1, 0, -1, 0};
    static ArrayList<int[]> dusts, cleaner;
    static Queue<int[]> queue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        dusts = new ArrayList<>();
        cleaner = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) dusts.add(new int[] {i, j});
                else if (arr[i][j] == -1) cleaner.add(new int[] {i, j});
            }
        }
        queue = new ArrayDeque<>();
        while(T-- > 0) {
            checkDust();
            bfsDust();
//            for (int i = 0; i < R; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }System.out.println();
            dfsClenaer();


        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) ans += arr[i][j];
            }
        }
        System.out.println(ans);
    }
    private static void dfsClenaer() {
        doTop();
        doBottom();

    }

    private static void doBottom() {
        int[] cleanBottom = cleaner.get(1);
        int r = cleanBottom[0];
        int c = cleanBottom[1];
        int d = 0;
        int next = 0;
        int prev = 0;
        r = r + dr[0];
        c = c + dc[0];
        int tmp1 = arr[r][c];
        int tmp2 = arr[r][c];
        arr[r][c] = 0;
        while(true) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!check(nr, nc)) {
                d++;
                d = d % 4;
                continue;
            }
            if (arr[nr][nc] == -1) {
                break;
            }

            tmp2 = arr[nr][nc];
            arr[nr][nc] = tmp1;
            tmp1 = tmp2;
            r = nr;
            c = nc;
        }
    }

    private static void doTop() {
        int[] cleanTop = cleaner.get(0);
        int r = cleanTop[0];
        int c = cleanTop[1];
        int d = 0;
        r = r + tdr[0];
        c = c + tdc[0];
        int tmp1 = arr[r][c];
        int tmp2 = arr[r][c];
        arr[r][c] = 0;
        while(true) {
            int nr = r + tdr[d];
            int nc = c + tdc[d];
            if (!check(nr, nc)) {
                d++;
                d = d % 4;
                continue;
            }
            if (arr[nr][nc] == -1) {
                break;
            }
            tmp2 = arr[nr][nc];
            arr[nr][nc] = tmp1;
            tmp1 = tmp2;
            r = nr;
            c = nc;
        }
    }

    private static void bfsDust() {
        boolean [][] visited = new boolean[R][C];
        int[][] tempArr = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }
        for(int[] dust : dusts) {
            queue.offer(new int[] {dust[0], dust[1]});
        }
        dusts.clear();
        int size = queue.size();
        while (size-- > 0) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            if (visited[r][c]) continue;
            visited[r][c] = true;
//			if (arr[r][c] < 0) continue;
            int expValue = (int) (tempArr[r][c]/5);
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!check(nr, nc)) continue;
                if (arr[nr][nc] == -1) continue;
//                expandDust(r, c, nr, nc, expValue);
                arr[nr][nc] += expValue;
                cnt++;
                queue.offer(new int[] {nr, nc});
            }
            arr[r][c] -= (expValue * cnt);
        }
    }
    private static void expandDust(int r, int c, int nr, int nc, int expValue) {
        arr[r][c] -= expValue;
        arr[nr][nc] += expValue;
//        System.out.println("r = "+ r + " c = " + c + " nr = " + nr + " nc = "+ nc + " value = " + expValue + " arr[r][c] = " + arr[r][c]);

    }
    private static boolean check(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= R || nc >= C) return false;
        return true;
    }
    static void checkDust(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 0 || arr[i][j] == -1) continue;
                dusts.add(new int[] {i, j});
            }
        }
    }
}
