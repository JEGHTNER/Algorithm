import sys
from collections import deque

N, M = map(int,input().split())
graph = [[] for _ in range(N)]
visited = [0 for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(i, depth):
    visited[i] = 1
    if depth == 4:
        print(1)
        sys.exit()
    for i in graph[i]:
        if not visited[i]:
            dfs(i, depth + 1)
            visited[i] = 0

for i in range(N):
    dfs(i, 0)
    visited[i] = 0
print(0)