import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
table = []
for i in range(N):
    table.append(list(map(int, sys.stdin.readline().split())))
visited = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

mx = 0
cnt = 0
area = 0

def bfs(i, j):
    queue = deque()
    queue.append([i, j])
    visited[i][j] = 1
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    global area
    global mx
    area = 0
    while queue:
        area += 1
        x, y = queue.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and table[nx][ny] == 1:
                visited[nx][ny] = 1
                queue.append([nx, ny])
    mx = max(mx, area)

for i in range(N):
    for j in range(M):
        if not visited[i][j] and table[i][j] == 1:
            cnt += 1
            bfs(i, j)


print(cnt)
print(mx)