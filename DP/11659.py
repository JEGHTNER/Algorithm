import sys

def getPartSum(start, end):
    return dp[end] - dp[start - 1]

N, M = map(int, sys.stdin.readline().split())

lst = list(map(int, sys.stdin.readline().split()))
dp = [0] * (N + 1)
for i in range(1, N + 1):
    dp[i] = lst[i - 1] + dp[i - 1]

for i in range(M):
    i, j = map(int, sys.stdin.readline().split())
    print(getPartSum(i, j))
