import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc < T; tc++) {
            int N;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            String arr[][] = new String[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    arr[i][j] = st.nextToken();
            }
            String rotate_90[] = new String[N];
            String rotate_180[] = new String[N];
            String rotate_270[] = new String[N];


            for (int i = 0; i < N; i++) {
                String tmp_90 = "";
                String tmp_180 = "";
                String tmp_270 = "";
                for (int j = 0; j < N; j++) {
                    tmp_90 += arr[N - 1 - j][i];
                    tmp_180 += arr[N - 1 - i][N - 1 - j];
                    tmp_270 += arr[j][N - 1 - i];
                }
                rotate_90[i] = tmp_90;
                rotate_180[i] = tmp_180;
                rotate_270[i] = tmp_270;
            }
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                System.out.println(rotate_90[i] + " " + rotate_180[i] +" " + rotate_270[i]);
            }
        }
    }
}
