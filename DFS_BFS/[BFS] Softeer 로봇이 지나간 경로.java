import java.io.*;
import java.util.*;

public class Main {
    static int H, W, startR, startC, dir;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      H = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      arr = new int[H][W];
      for(int i = 0; i < H; i++){
        String input = br.readLine();
        for(int j = 0; j < W; j++){
          if(input.charAt(j) == '.') arr[i][j] = 0;
          else if(input.charAt(j) == '#') {
              arr[i][j] = 1;
              startR = i;
              startC = j;
            }
        }
      }
      // for(int k = 0; k < H; k++){
      //   System.out.println(Arrays.toString(arr[k]));
      // }
      //find start point
      findStartPoint();
      //find start direction
      findDirection();
      String direction = "^>v<";
      System.out.println((startR + 1) + " "+ (startC + 1) + "\n" + direction.charAt(dir));
      //follow # line
      followLine();
      System.out.println(sb);
    }
  public static void findStartPoint(){
    Queue<int []> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[H][W];
    queue.offer(new int[] {startR, startC});
    visited[startR][startC] = true;
    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];
      for(int d = 0; d < 4; d++){
        int nr = r + dr[d];
        int nc = c + dc[d];
        if(!check(nr, nc)) continue;
        if (visited[nr][nc]) continue;
        visited[nr][nc] = true;
        queue.offer(new int[] {nr, nc});
        startR = nr;
        startC = nc;
      }
    }
  }
  public static void findDirection(){
    for(int d = 0; d < 4; d++){
      int nr = startR + dr[d];
      int nc = startC + dc[d];
      if (!check(nr, nc)) continue;
      // if (visited[nr][nc]) continue;
      dir = d;
    }
  }

  public static void followLine(){
    boolean[][] visited = new boolean[H][W];
    Queue<int []> queue = new ArrayDeque<>();
    queue.offer(new int[] {startR, startC});
    visited[startR][startC] = true;
    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];
      for(int d = 0; d < 4; d++){
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (!check(nr, nc)) continue;
        if (visited[nr][nc]) continue;
        visited[nr][nc] = true;
        // if (dir != d){
        //   changeDir(d);
        //   queue.offer(new int[] {nr, nc});
        // }else {
        //   move(nr, nc, d, visited, queue);
        //   System.out.println("move " + nr + " " + nc + " " + d );
        // }
        changeDir(d);
        move(nr, nc, d, visited,queue);
      }
      // for(int k = 0; k < H; k++){
      //   System.out.println(Arrays.toString(visited[k]));
      // }System.out.println();
    }
  
  }
  // ^>v< 0123
  // ^ 0 L = < 3 R = > 1
  // > 1 L = ^ 0 R = v 2
  // v 2 L = > 1 R = < 3
  // < 3 L = v 2 R = ^ 0
  public static void changeDir(int d){
    if ( d == (dir + 3) % 4) sb.append("L");
    else if (d == (dir + 1) % 4) sb.append("R");
    dir = d;
    
  }

  public static void move(int nr, int nc, int d, boolean[][] visited, Queue<int[]> queue){
    int nnr = nr + dr[d];
    int nnc = nc + dc[d];
    visited[nnr][nnc] = true;
    queue.offer(new int[] {nnr, nnc});
    sb.append("A");
  }
  
  public static boolean check(int nr, int nc){
    if(nr < 0 || nc < 0 || nr >= H || nc >= W) return false;
    if(arr[nr][nc] == 0) return false;
    return true;
  }
}
import java.io.*;
import java.util.*;

public class Main {
    static int H, W, startR, startC, dir;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      H = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      arr = new int[H][W];
      for(int i = 0; i < H; i++){
        String input = br.readLine();
        for(int j = 0; j < W; j++){
          if(input.charAt(j) == '.') arr[i][j] = 0;
          else if(input.charAt(j) == '#') {
              arr[i][j] = 1;
              startR = i;
              startC = j;
            }
        }
      }
      // for(int k = 0; k < H; k++){
      //   System.out.println(Arrays.toString(arr[k]));
      // }
      //find start point
      findStartPoint();
      //find start direction
      findDirection();
      String direction = "^>v<";
      System.out.println((startR + 1) + " "+ (startC + 1) + "\n" + direction.charAt(dir));
      //follow # line
      followLine();
      System.out.println(sb);
    }
  public static void findStartPoint(){
    Queue<int []> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[H][W];
    queue.offer(new int[] {startR, startC});
    visited[startR][startC] = true;
    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];
      for(int d = 0; d < 4; d++){
        int nr = r + dr[d];
        int nc = c + dc[d];
        if(!check(nr, nc)) continue;
        if (visited[nr][nc]) continue;
        visited[nr][nc] = true;
        queue.offer(new int[] {nr, nc});
        startR = nr;
        startC = nc;
      }
    }
  }
  public static void findDirection(){
    for(int d = 0; d < 4; d++){
      int nr = startR + dr[d];
      int nc = startC + dc[d];
      if (!check(nr, nc)) continue;
      // if (visited[nr][nc]) continue;
      dir = d;
    }
  }

  public static void followLine(){
    boolean[][] visited = new boolean[H][W];
    Queue<int []> queue = new ArrayDeque<>();
    queue.offer(new int[] {startR, startC});
    visited[startR][startC] = true;
    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];
      for(int d = 0; d < 4; d++){
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (!check(nr, nc)) continue;
        if (visited[nr][nc]) continue;
        visited[nr][nc] = true;
        // if (dir != d){
        //   changeDir(d);
        //   queue.offer(new int[] {nr, nc});
        // }else {
        //   move(nr, nc, d, visited, queue);
        //   System.out.println("move " + nr + " " + nc + " " + d );
        // }
        changeDir(d);
        move(nr, nc, d, visited,queue);
      }
      // for(int k = 0; k < H; k++){
      //   System.out.println(Arrays.toString(visited[k]));
      // }System.out.println();
    }
  
  }
  // ^>v< 0123
  // ^ 0 L = < 3 R = > 1
  // > 1 L = ^ 0 R = v 2
  // v 2 L = > 1 R = < 3
  // < 3 L = v 2 R = ^ 0
  public static void changeDir(int d){
    if ( d == (dir + 3) % 4) sb.append("L");
    else if (d == (dir + 1) % 4) sb.append("R");
    dir = d;
    
  }

  public static void move(int nr, int nc, int d, boolean[][] visited, Queue<int[]> queue){
    int nnr = nr + dr[d];
    int nnc = nc + dc[d];
    visited[nnr][nnc] = true;
    queue.offer(new int[] {nnr, nnc});
    sb.append("A");
  }
  
  public static boolean check(int nr, int nc){
    if(nr < 0 || nc < 0 || nr >= H || nc >= W) return false;
    if(arr[nr][nc] == 0) return false;
    return true;
  }
}
