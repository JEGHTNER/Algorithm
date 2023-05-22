import sys
from collections import deque

R, C = map(int, sys.stdin.readline().split())
maze = []
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for i in range(R):
    maze.append(sys.stdin.readline().rstrip())
visited_F = [[-1 for _ in range(1001)] for _ in range(1001)]
visited_J = [[-1 for _ in range(1001)] for _ in range(1001)]

queue_F = deque()
for i in range(R):
    for j in range(C):
        if maze[i][j] == 'J':
            J = [i, j]
        elif maze[i][j] == 'F':
            queue_F.append([i, j])
            visited_F[i][j] = 0


def bfs_F():
    while queue_F:
        x, y = queue_F.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= R or ny < 0 or ny >= C : continue
            if visited_F[nx][ny] >= 0 or maze[nx][ny] == '#' : continue
            visited_F[nx][ny] = visited_F[x][y] + 1
            queue_F.append([nx, ny])

def bfs_J(i, j):
    queue = deque()
    queue.append([i, j])
    visited_J[i][j] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 > nx or nx  >= R or  0 > ny or ny >= C:
                print(visited_J[x][y] + 1)
                return
            if visited_J[nx][ny] >= 0 or maze[nx][ny] == '#': continue
            if visited_F[nx][ny] != -1 and visited_F[nx][ny] <= visited_J[x][y] + 1: continue
            visited_J[nx][ny] = visited_J[x][y] + 1
            queue.append([nx, ny])
    print("IMPOSSIBLE")
bfs_F()
bfs_J(J[0], J[1])
