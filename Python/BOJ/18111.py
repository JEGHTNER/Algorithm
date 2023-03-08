import sys

N, M, B = map(int, sys.stdin.readline().split())
time = sys.maxsize
table = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

for floor in range(257):
    max_floor, min_floor = 0, 0
    for i in range(N):
        for j in range(M):
            if table[i][j] >= floor:
                max_floor += table[i][j] - floor
            else:
                min_floor += floor - table[i][j]
    if max_floor + B >= min_floor:
        if min_floor + (max_floor * 2) <= time:
            time = min_floor + max_floor * 2
            idx = floor

print(time, idx)