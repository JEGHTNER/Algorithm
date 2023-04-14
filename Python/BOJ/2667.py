import sys
from collections import deque

N = int(sys.stdin.readline())
cnt = 0
arr = []
ans = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().rstrip())))
visited = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(i, j):
    global cnt
    if visited[i][j] == 0 and arr[i][j] != 0:
        cnt += 1
    stack = [(i, j)]
    depth = 0
    while stack:
        tmp = stack.pop()
        nx, ny = tmp[0], tmp[1]
        if visited[nx][ny] == 0:
            visited[nx][ny] = 1
            if arr[nx][ny] == 1:
                depth += 1
                arr[nx][ny] = depth
                for i in range(4):
                    if 0 <= nx + dx[i] < N and 0 <= ny + dy[i] < N:
                        stack.append((nx + dx[i], ny + dy[i]))
    if depth != 0:
        ans.append(depth)


for i in range(N):
    for j in range(N):
        dfs(i, j)
print(cnt)
ans.sort()
for a in ans:
    print(a)
