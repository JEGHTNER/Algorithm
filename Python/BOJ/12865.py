import sys

#solution 1
# N, K = map(int, sys.stdin.readline().split())
# stuff = [[0,0]]
# knapsack = [[0 for _ in range( K + 1)] for _ in range(N + 1)]
#
# for i in range(N):
#     stuff.append(list(map(int, sys.stdin.readline().split())))
#
# for i in range(1, N + 1):
#     for j in range(1, K + 1):
#         weight = stuff[i][0]
#         value = stuff[i][1]
#
#         if j < weight :
#             knapsack[i][j] = knapsack[i - 1][j]
#         else:
#             knapsack[i][j] = max(value + knapsack[i - 1][j - weight], knapsack[i - 1][j])
#
# print(knapsack[N][K])

N, K = map(int, sys.stdin.readline().split())

knapsack = {0: 0}
for i in range(N):
    weight, value = map(int, sys.stdin.readline().split())
    tmp ={}
    for v, w in knapsack.items():
        nv, nw = v + value, w + weight
        if nw < knapsack.get(nv, K + 1):
            tmp[nv] = nw
    knapsack.update(tmp)
print(max(knapsack.keys()))

