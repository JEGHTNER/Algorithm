import sys

n = int(sys.stdin.readline())
table = [[0 for _ in range(100)]for _ in range(100)]
count = 0
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    for j in range(10):
        for k in range(10):
            if table[y + j][x + k] == 0:
                table[y + j][x + k] = 1
                count += 1

print(count)


