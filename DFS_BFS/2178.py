import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
maze = []
for i in range(N):
    maze.append(list(map(int, sys.stdin.readline().rstrip())))
visited = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
dx = [1,-1, 0,0]
dy = [0,0,-1, 1]


def bfs(i, j):
    queue = deque()
    queue.append([(i, j), 1])
    depth = 0
    while queue:
        tmp = queue.popleft()
        nx, ny, depth = tmp[0][0], tmp[0][1], tmp[1]
        if visited[nx][ny] == 0:
            visited[nx][ny] = 1
            if maze[nx][ny] == 1:
                maze[nx][ny] = depth
                for i in range(4):
                    if 0 <= nx + dx[i] < N and 0 <= ny + dy[i] < M:
                        queue.append([(nx + dx[i], ny + dy[i]), depth + 1])

bfs(0,0)
print(maze[N - 1][M - 1])
