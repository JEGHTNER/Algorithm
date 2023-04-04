import sys
import heapq

V, E = map(int, sys.stdin.readline().split())

K = int(sys.stdin.readline())

INF = int(1e9)

graph = [[] for _ in range(V + 1)]

dp =[INF] * 20001
for _ in range(E):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append([v, w])

def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))
    dp[start] = 0

    while queue:
        distance, now = heapq.heappop(queue)
        if dp[now] < distance:
            continue
        for i in graph[now]:
            cost = distance + i[1]
            if cost < dp[i[0]]:
                dp[i[0]] = cost
                heapq.heappush(queue, (cost, i[0]))
dijkstra(K)

for i in range(1, V + 1):
    if dp[i] == INF:
        print("INF")
    else:
        print(dp[i])