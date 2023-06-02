import sys
from collections import deque

N = int(sys.stdin.readline())
one, two = map(int, sys.stdin.readline().split())
M = int(sys.stdin.readline())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
for i in range(M):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

def bfs(n):
    queue = deque()
    queue.append([n, 0])
    visited[n] = 1

    while queue:
        v, cnt = queue.popleft()

        if v == two:
            return cnt
        for i in graph[v]:
            if not visited[i]:
                queue.append([i, cnt + 1])
                visited[i] = 1
    return -1

print(bfs(one))