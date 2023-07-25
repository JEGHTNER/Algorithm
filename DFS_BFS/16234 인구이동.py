import sys
from collections import deque

N, L, R = map(int, input().split())
table = []
visited = [[0 for _ in range(N)] for _ in range(N)]
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

for i in range(N):
    line = list(map(int, input().split()))
    table.append(line)

def bfs(x, y):
    global flag
    queue = deque()
    queue.append([x, y])
    check = deque()
    visited[x][y] = 1
    check.append([x, y])
    sum = table[x][y]
    cnt = 1
    while queue:
        tmp = queue.popleft()
        r = tmp[0]
        c = tmp[1]
        visited[r][c] = 1
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if nr < 0 or nr >= N or nc < 0 or nc >= N:
                continue
            if visited[nr][nc] != 0:
                continue
            if not L <= abs(table[r][c] - table[nr][nc]) <= R:
                continue
            visited[nr][nc] = 1
            queue.append([nr, nc])
            check.append([nr, nc])
            sum += table[nr][nc]
            cnt += 1
    avg = sum//cnt
    while check:
        tmp = check.popleft()
        r = tmp[0]
        c = tmp[1]
        table[r][c] = avg
    if cnt != 1:
        flag += 1

ans = 0

while True:
    flag = 0
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                bfs(i, j)
    visited = [[0 for _ in range(N)] for _ in range(N)]
    # print(flag)
    if flag != 0:
        ans += 1
    else:
        break

print(ans)