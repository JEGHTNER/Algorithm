T = int(input())

for tc in range(1, T + 1):
    sudoku = []
    for i in range(9):
        sudoku.append(list(map(int, input().split())))

    def check_row(x):
        check_list = []
        for i in range(9):
            if sudoku[x][i] in check_list:
                return 0
            check_list.append(sudoku[x][i])
        return 1

    def check_col(y):
        check_list = []
        for i in range(9):
            if sudoku[i][y] in check_list:
                return 0
            check_list.append(sudoku[i][y])
        return 1

    def check_square(x, y):
        check_list = []
        for i in range(3):
            for j in range(3):
                if sudoku[x + i][y + j] in check_list:
                    return 0
                check_list.append(sudoku[x + i][y + j])
        return 1

    def check_3b3():
        for i in [0, 3, 6]:
            for j in [0, 3, 6]:
                if not check_square(i, j):
                    return 0
        return 1

    def check():
        for i in range(9):
            if not check_row(i):
                return 0
            if not check_col(i):
                return 0
        if not check_3b3():
            return 0
        return 1
    print("#", end="")
    print(tc, check())