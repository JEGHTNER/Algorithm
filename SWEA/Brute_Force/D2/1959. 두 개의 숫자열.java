package test;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test {
    public static void main(String[] arg) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int[] A = new int[N];
        	for (int i = 0; i < N; i++)
        		A[i] = sc.nextInt();
        	int[] B = new int[M];
        	for (int i = 0; i < M; i++)
        		B[i] = sc.nextInt();
        	int ans = -2147483648;
        	int tmp_sum = 0;
        	if (N > M)
        	{
        		for (int i = 0; i < (N - M + 1); i++)
        		{
        			tmp_sum = 0;
        			for (int j = 0; j < M; j++)
        				tmp_sum += A[i + j] * B[j];
        			ans = Math.max(ans, tmp_sum);
        		}
        	}
        	else if (N < M)
        	{
        		for (int i = 0; i < (M - N + 1); i++)
        		{
        			tmp_sum = 0;
        			for (int j = 0; j < N; j++)
        				tmp_sum += B[i + j] * A[j];
        			ans = Math.max(ans, tmp_sum);
        		}
        	}
        	else
        	{
        		for (int i = 0; i < N; i++)
        			tmp_sum += A[i] * B[i];
        		ans = Math.max(ans, tmp_sum);
        	}

        	System.out.println("#"+ tc + " " + ans);
        }

    }
} 