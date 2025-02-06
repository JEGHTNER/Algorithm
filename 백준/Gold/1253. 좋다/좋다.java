import java.io.*;
import java.util.*;

public class Main {

    static int N, count;
    static int []arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j == i) continue;
                int target = arr[i] - arr[j];
                int left = Arrays.binarySearch(arr, 0, j, target);
                int right = Arrays.binarySearch(arr, j, N, target);
//                System.out.println("i " + i + " j " + j + " target " + target + " left " + left + " right" + right);
                if( (left >= 0 && left != i && left != j) || (right >= 0 && right != i && right != j)) {
                    count++;
//                    System.out.println("target: "+target);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}