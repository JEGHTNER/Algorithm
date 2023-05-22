import sys
from collections import deque
N, M, R = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N + 1)]
visited = [0 for _ in range(N + 1)]

for i in range(M):
    u, v = map(int ,sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for g in graph:
    g.sort(reverse=True)

def bfs():
    queue = deque()
    queue.append(R)
    depth = 0
    while queue:
        tmp = queue.popleft()
        if visited[tmp] == 0:
            depth += 1
            visited[tmp] = depth
            for num in graph[tmp]:
                queue.append(num)

bfs()
for i in visited[1:]:
    print(i)