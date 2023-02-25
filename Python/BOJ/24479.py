import sys
n, m, r = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n + 1)]
visited=[0 for _ in range(n + 1)]
for i in range(1, m+1):
    left, right = map(int, sys.stdin.readline().split())
    graph[left].append(right)
    graph[right].append(left)

for i in range(1, n + 1):
    graph[i] = sorted(graph[i], reverse= True)

def dfs():
    depth = 0
    stack = []
    stack.append(r)
    while stack:
        tmp = stack.pop()
        if not visited[tmp]:
            depth += 1
            visited[tmp] = depth
            for num in graph[tmp]:
                stack.append(num)

dfs()
for v in visited[1:]:
    print(v)