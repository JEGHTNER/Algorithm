import sys
from collections import deque

N, M, R = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]
visited = [0 for _ in range(N + 1)]

for i in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for g in graph:
    g.sort()


def bfs(R):
    depth = 0
    queue = deque()
    queue.append(R)
    while queue:
        tmp = queue.popleft()
        if visited[tmp] == 0:
            depth += 1
            visited[tmp] = depth
            for num in graph[tmp]:
                queue.append(num)


bfs(R)
for v in visited[1:]:
    print(v)