import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2239 {
    static int[][] arr;
    static ArrayList<int[]> list;
    static boolean[][] visitedR = new boolean[9][10];
    static boolean[][] visitedC = new boolean[9][10];
    static boolean[][] visitedB = new boolean[9][10];
    static int[] sol;
    static int D;
    static boolean stop;
    public static void main(String[] args) throws Exception{
        arr = new int[9][9];
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                if (arr[i][j] == 0){
                    list.add(new int[] {i, j});
                }else{
                    int num = arr[i][j];
                    visitedR[i][num] = true;
                    visitedC[j][num] = true;
                    visitedB[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }
        D = list.size();
        sol = new int[D];
        dfs(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]);
            }sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int depth) {
        if (depth == D){
            for (int i = 0; i < D; i++) {
                int r = list.get(i)[0];
                int c = list.get(i)[1];
                arr[r][c] = sol[i];
            }
            stop = true;
            return ;
        }
        int r = list.get(depth)[0];
        int c = list.get(depth)[1];
        int b = (r / 3) * 3 +  (c / 3);

        for (int i = 1; i <= 9; i++) {
            if (visitedR[r][i] || visitedC[c][i] || visitedB[b][i]) continue;
            visitedR[r][i] = true;
            visitedC[c][i] = true;
            visitedB[b][i] = true;
            sol[depth] = i;
            dfs(depth + 1);
            if (stop){
                return;
            }
            visitedR[r][i] = false;
            visitedC[c][i] = false;
            visitedB[b][i] = false;
        }
    }
}
