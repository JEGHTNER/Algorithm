import sys

N = int(sys.stdin.readline())
table = [list(sys.stdin.readline().rstrip()) for _ in range(N)]

def dfs(x , y, n):
    if n == 1:
        print(table[x][y], end ="")
        return
    color = table[x][y]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if table[i][j] != color:
                print("(", end ="")
                dfs(x, y, n //2)
                dfs(x, y + n//2, n//2)
                dfs(x + n // 2, y, n // 2)
                dfs(x + n//2, y + n//2, n//2)
                print(")", end= "")
                return
    print(color, end= "")
    return
dfs(0,0,N)
