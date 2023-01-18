import sys
from collections import deque
# dfs
# def solution():
#     n = int(sys.stdin.readline())
#     pair_len = int(sys.stdin.readline())
#     infected = []
#     stack = [1]
#     graph =[[] for i in range(n+1)]
#     for i in range(pair_len):
#         left, right = map(int, sys.stdin.readline().split())
#         graph[left].append(right)
#         graph[right].append(left)
#     while stack:
#         i = stack.pop()
#         if i not in infected:
#             infected.append(i)
#             for j in graph[i]:
#                 stack.append(j)
#
#     print(len(infected)-1)
#bfs

def bfs(start,graph,infected):
    queue = deque()
    queue.append(start)

    while queue:
        i = queue.popleft()
        for j in graph[i]:
            if j not in infected:
                queue.append(j)
                infected.append(j)


def solution():
    n = int(sys.stdin.readline())
    pair_len = int(sys.stdin.readline())
    infected = []
    graph =[[] for i in range(n+1)]
    for i in range(pair_len):
            left, right = map(int, sys.stdin.readline().split())
            graph[left].append(right)
            graph[right].append(left)
    bfs(1, graph, infected)

    #print(graph)
    print(len(infected) - 1)

solution()
