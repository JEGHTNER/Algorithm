import sys
from collections import deque
import heapq


class Node:
    def __init__(self, end, cost):
        self.end = end
        self.cost = cost

    def __lt__(self, other):
        return self.cost < other.cost

    def __repr__(self):
        return f"end:{self.end} cost:{self.cost}"


def dijkstra(start):
    pq = []
    heapq.heappush(pq, Node(start, 0))
    distance = [sys.maxsize for i in range(N+1)]
    distance[start] = 0
    visited = [False for i in range(N + 1)]
    while pq:
        cur = heapq.heappop(pq)
        visited[cur.end] = True
        for node in graph[cur.end]:
            if visited[node.end]:
                continue
            if distance[node.end] <= distance[cur.end] + node.cost:
                continue
            distance[node.end] = distance[cur.end] + node.cost
            heapq.heappush(pq, Node(node.end, distance[node.end]))
        # print("cur",cur," node",node, distance)
    return distance





N, E = map(int, input().split())
ans = -1
graph = [[] for _ in range(N + 1)]
for i in range(E):
    a, b, c = map(int, input().split())

    graph[a].append(Node(b,c))
    graph[b].append(Node(a,c))

v1, v2 = map(int, input().split())

# print(graph)

distance1 = dijkstra(1)
distance2 = dijkstra(v1)
distance3 = dijkstra(v2)

# print("distance1", distance1[1:])
# print("distance2", distance2[1:])
# print("distance3", distance3[1:])
if distance1[v1] == sys.maxsize or distance2[v2] == sys.maxsize or distance3[N] == sys.maxsize:
    ans = -1
else:
    ans = min(distance1[v1] + distance2[v2] + distance3[N], distance1[v2] + distance2[N] + distance3[v1])
print(ans)




