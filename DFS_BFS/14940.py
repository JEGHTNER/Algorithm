import sys
from collections import deque
N, M = map(int, sys.stdin.readline().split())
arr = []
visited = [[-1] * M for _ in range(N)]
# x, y = 0, 0
for i in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    arr.append(line)
    # if 2 in line:
    #     x = i
    #     y = line.index(2)

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs(i, j):
    queue = deque()
    queue.append([i, j])
    visited[i][j] = 0
    while queue:
        x_, y_ = queue.popleft()
        for idx in range(4):
            nx = x_ + dx[idx]
            ny = y_ + dy[idx]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if visited[nx][ny] > 0:
                continue
            if arr[nx][ny] == 0:
                visited[nx][ny] = 0
            if arr[nx][ny] != 1:
                continue
            queue.append([nx,ny])
            visited[nx][ny] = visited[x_][y_] + 1


for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            bfs(i, j)
        if arr[i][j] == 0 and visited[i][j] == -1:
            visited[i][j] = 0
for v in visited:
    for j in v:
        print(j, end=" ")
    print()