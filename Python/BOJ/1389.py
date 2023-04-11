import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]
for i in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graph[A].append(B)
    graph[B].append(A)



def bfs(start):
    visited = [0 for _ in range(N + 1)]
    visited[start] = 1
    num = [0 for _ in range(N + 1)]
    queue = deque()
    queue.append(start)
    while queue:
        tmp = queue.popleft()
        for i in graph[tmp]:
            if visited[i] == 0:
                visited[i] = 1
                num[i] = num[tmp] + 1
                queue.append(i)
    return(sum(num))

ans = []
for i in range(1, N + 1):
    ans.append(bfs(i))

print(ans.index(min(ans)) + 1)
