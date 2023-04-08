import sys
from collections import deque

N = int(sys.stdin.readline())

lst = []
for i in range(N):
    lst.append(list(sys.stdin.readline().rstrip()))
visited = [[0 for _ in range(N)] for _ in range(N)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(x, y):
    queue = deque()
    queue.append([x,y])
    visited[x][y] = 1
    while queue:
        cur_x, cur_y = queue.popleft()
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if lst[nx][ny] == lst[cur_x][cur_y]:
                    queue.append([nx, ny])
                    visited[nx][ny] = 1

cnt_1, cnt_2 = 0,0

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            cnt_1 += 1

for i in range(N):
    for j in range(N):
        if lst[i][j] == 'R':
            lst[i][j] = 'G'

queue = deque()
visited = [[0 for _ in range(N)] for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            cnt_2 += 1
print(cnt_1, cnt_2)
