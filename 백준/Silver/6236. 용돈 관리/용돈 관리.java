
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, left, right;
    static int []arr;

    public static boolean check(int mid){
        int temp = mid;
        int count = 1;
        for(int i = 0; i < N; i++){
            if(arr[i] <= mid){
                mid -= arr[i];
            }else{
                mid = temp;
                count++;
                if(arr[i] > mid)return false;
                else
                    mid -= arr[i];
            }
        }
        return count <= M;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        left = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.min(left, arr[i]);
            right += arr[i];
        }
        int result = 0;
        while(left <= right){
            int mid = (left + right) /2;
            if (check(mid)){
                right = mid - 1;
                result = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}