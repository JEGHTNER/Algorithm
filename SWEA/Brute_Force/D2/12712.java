import java.util.*;
import java.io.*;
public class Main {
    public static int calc_1(int x, int y, int N, int M, int[][] arr)
    {
        int ret = arr[x][y];
        int nx, ny = 0;
        for (int i = 1; i < M; i++)
        {
            nx = x - i;
            if (nx < 0)
                continue;
            ret += arr[nx][y];
        }
        for (int i = 1; i < M; i++)
        {
            nx = x + i;
            if (N <= nx)
                continue;
            ret += arr[nx][y];
        }
        for (int i = 1; i < M; i++)
        {
            ny = y - i;
            if (ny < 0)
                continue;
            ret += arr[x][ny];
        }
        for (int i = 1; i < M; i++)
        {
            ny = y + i;
            if (N <= ny)
                continue;
            ret += arr[x][ny];
        }
        return ret;
    }
    public static int calc_2(int x, int y, int N, int M, int[][] arr)
    {
        int ret = arr[x][y];
        int nx, ny = 0;
        for (int i = 1; i < M; i++)
        {
            nx = x - i;
            ny = y - i;
            if (nx < 0 || ny < 0)
                continue;
            ret += arr[nx][ny];
        }
        for (int i = 1; i < M; i++)
        {
            nx = x + i;
            ny = y + i;
            if (N <= nx || N <= ny)
                continue;
            ret += arr[nx][ny];
        }
        for (int i = 1; i < M; i++)
        {
            nx = x - i;
            ny = y + i;
            if (nx < 0 || N <= ny)
                continue;
            ret += arr[nx][ny];
        }
        for (int i = 1; i < M; i++)
        {
            nx = x + i;
            ny = y - i;
            if (ny < 0 || N <= nx)
                continue;
            ret += arr[nx][ny];
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N, M;
            N = sc.nextInt();
            M = sc.nextInt();
            int ans = -2147483648;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    arr[i][j] = sc.nextInt();

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    ans = Math.max(ans, Math.max(calc_1(i, j, N, M, arr), calc_2(i, j, N, M, arr)));
                }
            System.out.println("#" + tc + " " + ans);
        }
    }
}