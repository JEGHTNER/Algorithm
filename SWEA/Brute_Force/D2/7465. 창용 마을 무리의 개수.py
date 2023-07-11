from collections import deque

T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    visited = [0 for _ in range(N + 1)]
    for i in range(M):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    cnt = 0

    def bfs():
        queue = deque()
        queue.append(i)
        while queue:
            tmp = queue.popleft()
            if visited[tmp] != 0:
                continue
            visited[tmp] = cnt
            for g in graph[tmp]:
                queue.append(g)

    for i in range(1, N + 1):
        if visited[i]:
            continue
        cnt += 1
        bfs()
    print("#", end="")
    print(tc, cnt)

