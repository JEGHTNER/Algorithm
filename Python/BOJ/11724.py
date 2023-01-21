import sys
from collections import deque
sys.setrecursionlimit(10000)

def dfs(visited, v, graph):
    stack = [v]
    visited[v] = True
    while stack:
        i = stack.pop()
        for j in graph[i]:
            if not visited[j]:
                stack.append(j)
                visited[j] = True


def bfs(visited, v, graph):
    queue = deque([v])
    visited[v] = True
    while queue:
        i = queue.popleft()
        for j in graph[i]:
            if not visited[j]:
                queue.append(j)
                visited[j] = True


def solution():
    dots, lines = map(int, sys.stdin.readline().split())
    graph = [[] for i in range(dots + 1)]
    visited = [False] * (dots + 1)
    count = 0
    for i in range(lines):
        u, v = map(int, sys.stdin.readline().split())
        graph[u].append(v)
        graph[v].append(u)
    #print(graph)
    for v in range(1, dots + 1):
        if visited[v]: continue
        dfs(visited, v, graph)
        count += 1
    # for v in range(1, dots + 1):
    #     if visited[v] : continue
    #     bfs(visited, v, graph)
    #     count += 1
    print(count)

solution()