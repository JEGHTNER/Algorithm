import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Main {
    public static int check(int sudoku[][])
    {
        for (int i = 0; i < 9; i++) {
            if (check_row(sudoku, i) == 0)
                return 0;
            if (check_col(sudoku, i) == 0)
                return 0;
        }
        for (int i = 0; i < 9; i+=3)
            for (int j = 0; j < 9; j+=3) {
                if (check_3b3(sudoku, i, j) == 0)
                    return 0;
            }
        return 1;
    }
    public static int check_row(int[][] sudoku, int x)
    {
        ArrayList checkList = new ArrayList();
        for (int i = 0; i < 9; i++){
            if (checkList.contains(sudoku[x][i]))
                return 0;
            checkList.add(sudoku[x][i]);
        }
        return 1;
    }
    public static int check_col(int[][] sudoku, int y)
    {
        ArrayList checkList = new ArrayList();
        for (int i = 0; i < 9; i++){
            if (checkList.contains(sudoku[i][y]))
                return 0;
            checkList.add(sudoku[i][y]);
        }
        return 1;
    }
    public static int check_3b3(int[][] sudoku, int x, int y)
    {
        ArrayList checkList = new ArrayList();
        for (int i = 0; i < 3; i++){
            int nx = x + i;
            for (int j = 0; j < 3; j++){
                int ny = y + j;
                if (checkList.contains(sudoku[nx][ny]))
                    return 0;
                checkList.add(sudoku[nx][ny]);
            }
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int sudoku[][] = new int[9][9];
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    sudoku[i][j] = sc.nextInt();
//            System.out.println(Arrays.deepToString(sudoku));
            System.out.println("#" + tc + " " + check(sudoku));
        }
    }
}
