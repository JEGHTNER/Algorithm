import sys
from collections import deque
N = int(sys.stdin.readline())
arr = []
ans = [[0 for _ in range(N)] for _ in range(N)]
graph = [[] for _ in range(N)]
visited = [0 for _ in range(N)]

for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

# print(arr)
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            graph[i].append(j)

# print(graph)

def bfs(i):
    queue = deque()
    queue.append(i)
    flag = 0
    while queue:
        tmp = queue.popleft()
        if visited[tmp] == 0:
            visited[tmp] = 1
            for num in graph[tmp]:
                if num == i:
                    flag = 1
                queue.append(num)
    if flag == 0:
        visited[i] = 0

# bfs(0)
for i in range(N):
    visited = [0 for _ in range(N)]
    bfs(i)
    for v in visited:
        print(v, end= " ")
    print()