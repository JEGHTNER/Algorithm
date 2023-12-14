import java.io.*;
import java.util.*;

public class Main {

    static int n, m, ans, toFind;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static ArrayList<int []> toVisit = new ArrayList<>();
    // static ArrayList<int []> temp = new ArrayList<>();
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      arr = new int[n][n];
      visited = new boolean[n][n];
      m = Integer.parseInt(st.nextToken());
      for(int i = 0; i < n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++){
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      // for(int k = 0; k < n; k++){
      //   System.out.println(Arrays.toString(arr[k]));
      // }
      for(int i = 0; i < m; i++){
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        toVisit.add(new int[] {r-1, c-1});
      }
        // for(int[] temp : toVisit){
        //   System.out.println(Arrays.toString(temp));
        // }
      toFind = toVisit.size();
      int r = toVisit.get(0)[0];
      int c = toVisit.get(0)[1];
      visited[r][c] = true;
      dfs(r, c, 0, 1);
      System.out.println(ans);
    }

  public static void dfs(int r, int c, int depth, int found){
    // System.out.println(r + " " + c + " " + found + " " + toFind + " " + depth);
    if (depth == (n * n)){
      return ;
    }
    if (found == toFind){
      ans++;
      // for(int[] t : temp){
      //     System.out.print(Arrays.toString(t) + " ");
      //   }
      // System.out.println("ans = "+ans);
      return;
    }
    if (r == toVisit.get(toFind-1)[0] && c == toVisit.get(toFind-1)[1]){
      return ;
    }
    for(int d = 0; d < 4; d++){
      int nr = r + dr[d];
      int nc = c + dc[d];
      if (!check(nr, nc)) continue;
      if (visited[nr][nc]) continue;
      visited[nr][nc] = true;
      // temp.add(new int[] {nr, nc});
      if (toVisit.get(found)[0] == nr && toVisit.get(found)[1] == nc) {
        dfs(nr, nc, depth + 1, found + 1);
      }else{
        dfs(nr, nc, depth + 1, found);
      }
      // System.out.println("r = " + r + " c = " + c);
      // temp.remove(temp.size()-1);
      visited[nr][nc] = false;
    }
  }
  public static boolean check(int nr, int nc){
    if(nr < 0 || nc < 0 || nr >= n || nc >= n){
      return false;
    }
    if (arr[nr][nc] == 1) return false;
    return true;
  }
}
