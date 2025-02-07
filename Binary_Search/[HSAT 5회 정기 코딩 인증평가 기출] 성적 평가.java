import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr, ans;

    public static int lowerBound(int[] arr, int key){
        int low = 0; int high = N;
        while (low < high){
            int mid = (low + high) / 2;
            if(arr[mid] < key){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int[] arr, int key){
        int low = 0; int high = N;
        while(low < high){
            int mid = (low + high)/2;
            if(arr[mid] <= key){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low -1;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[4][N];
        ans = new int[4][N];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[3][j] += arr[i][j];
            }
        }
        // for(int i = 0; i < 4; i++){
        //     for(int j = 0; j < N; j++){
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i < 4; i++){
            int[] sortedArray = arr[i].clone();
            Arrays.sort(sortedArray);
            for(int j = 0; j < N; j++){
                ans[i][j] = N - upperBound(sortedArray, arr[i][j]);
                // System.out.println(Arrays.toString(arr[i]));
                // System.out.print("i " +i + " j "  +j+ " arr[i][j] " + arr[i][j] + " ");
                // System.out.println(ans[i][j]);
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < N; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
