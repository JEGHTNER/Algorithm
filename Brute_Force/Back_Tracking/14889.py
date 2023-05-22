import sys
from itertools import combination

# #first solution with dfs
# n = int(sys.stdin.readline())
# visited = [False for _ in range(n)]
# table = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# min_dif = int(1e9)


# def dfs(depth, idx):
#     global min_dif
#     if depth == n // 2:
#         power1, power2 = 0, 0
#         for i in range(n):
#             for j in range(n):
#                 if visited[i] and visited[j]:
#                     power1 += table[i][j]
#                 elif not visited[i] and not visited[j]:
#                     power2 += table[i][j]
#         min_dif = min(min_dif, abs(power1 - power2))
#         return

#     for i in range(idx, n):
#         if not visited[i]:
#             visited[i] = True
#             dfs(depth + 1, i + 1)
#             visited[i] = False
# dfs(0, 0)
# print(min_dif)

import sys
from itertools import combinations as cb

n = int(sys.stdin.readline())
table = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

row_sum = [sum(row) for row in table]
col_sum = [sum(col) for col in zip(*table)]
ans = [x + y for x, y in zip(row_sum, col_sum)]
total = sum(row_sum)
min_dif = min(abs(total - sum(comb)) for comb in cb(ans, n//2))
print(min_dif)