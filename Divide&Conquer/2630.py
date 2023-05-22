import sys

n = int(sys.stdin.readline())
square = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

result = []


def recur(y, x, n):
    color = square[y][x]
    for i in range(y, y + n):
        for j in range(x, x + n):
            if color != square[i][j]:
                recur(y, x, n//2)
                recur(y, x + n//2, n//2)
                recur(y + n//2, x, n//2)
                recur(y + n//2, x + n//2, n//2)
                return
    if color == 0:
        result.append(0)
    else :
        result.append(1)


recur(0, 0, n)
print(result.count(0))
print(result.count(1))