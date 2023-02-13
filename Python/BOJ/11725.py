import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [[] for i in range(n + 1)]
for i in range(n - 1):
    left, right = map(int, sys.stdin.readline().split())
    graph[left].append(right)
    graph[right].append(left)

queue = deque()
queue.append(1)
ans = [0]*(n+1)

def bfs():
    while queue:
        current = queue.popleft()
        for num in graph[current]:
            if ans[num] == 0:
                ans[num] = current
                queue.append(num)
bfs()
for i in range(2, len(ans)):
    print(ans[i])
