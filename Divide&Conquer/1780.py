import sys

N = int(sys.stdin.readline())
lst = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dic= {-1:0, 0:0, 1:0}
def dfs(x, y, n):
    num_check = lst[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if lst[i][j] != num_check:
                for k in range(3):
                    for l in range(3):
                        dfs(x + k * n // 3, y + l * n//3, n//3)
                return
    dic[num_check] += 1

dfs(0,0,N)
for num in dic.values():
    print(num)