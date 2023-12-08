import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static int[] arr;
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      q = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      arr = new int[n];
      for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      for(int i = 0; i < q; i++){
        int find = Integer.parseInt(br.readLine());
        int idx = Arrays.binarySearch(arr, find);
        // System.out.println("find = " + find + " " + idx);
        if (idx <= 0 || idx == n) System.out.println(0);
        else{
          int left = idx;
          int right = n - idx - 1;
          System.out.println(left*right);
        }
      }
    }
}

// 5 2 3 1 6
// 1 2 3 5 6
// 1 3 5, 1 3 6, 2 3 5, 2 3 6

// 7 4 3 2 6 1
// 1 2 3 4 6 7
// 1 2 3, 1 2 4, 1 2 6, 1 2 7
// 
