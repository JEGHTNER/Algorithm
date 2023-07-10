import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++)
        {
            int test_case = Integer.parseInt(br.readLine());
            int map[] = new int[101];
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                map[Integer.parseInt(st.nextToken())] += 1;
            int max = -2147483648;
            int idx = 0;
            for (int i = 1; i <= 100; i++)
            {
                if (max <= map[i])
                {
                    max = map[i];
                    idx = i;
                }
            }
            System.out.println("#" +test_case + " " + idx);
        }
    }
}
