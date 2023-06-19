import sys
import math

N, M = map(int, sys.stdin.readline().split())
table = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
visited = [ [0] * M for _ in range(N)]
for i in range(N):
    line = sys.stdin.readline().rstrip()
    table.append(line)
cnt = 0
def dfs(i, j):
    global cnt
    stack = []
    stack.append([i,j])
    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M :
                continue
            if visited[nx][ny] != 0:
                continue
            if table[nx][ny] == 'X':
                continue
            if table[nx][ny] == 'P':
                cnt += 1

            stack.append([nx,ny])
            visited[nx][ny] = 1


for i in range(N):
    for j in range(M):
        if table[i][j] == 'I':
            dfs(i, j)
            break
if cnt == 0:
    print("TT")
else:
    print(cnt)
    