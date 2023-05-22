import sys
sys.setrecursionlimit(10**6)

def dfs(table, x, y, m, n):
    if x < 0 or y < 0 or x >= m or y >= n:
        return
    if table[y][x] == 0:
        return
    if table[y][x] == 1:
        table[y][x] = -1
        dfs(table, x, y + 1, m, n)
        dfs(table, x + 1, y, m, n)
        dfs(table, x, y - 1, m, n)
        dfs(table, x - 1, y, m, n)

def solution():
    t = int(sys.stdin.readline())
    for tc in range(t):
        count = 0
        m, n, cabbage_len = map(int, sys.stdin.readline().split())
        table = [[0 for _ in range(m)] for _ in range(n)]
        for cabbage in range(cabbage_len):
            x, y = map(int, sys.stdin.readline().split())
            table[y][x] = 1
        for i in range(n):
            for j in range(m):
                if table[i][j] == 1:
                    dfs(table,j,i,m,n)
                    count += 1
        print(count)

solution()
