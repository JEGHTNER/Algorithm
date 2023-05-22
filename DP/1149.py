import sys

N = int(sys.stdin.readline())
dp = [[0] * 3 for _ in range(1001)]
R = [0] * 1001
G = [0] * 1001
B = [0] * 1001

for i in range(1, N + 1):
    num1, num2, num3 = map(int, sys.stdin.readline().split())
    R[i] = num1
    G[i] = num2
    B[i] = num3

dp[1][0] = R[1]
dp[1][1] = G[1]
dp[1][2] = B[1]

for i in range(2, N + 1):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + R[i]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + G[i]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + B[i]

print(min(dp[N][0], dp[N][1], dp[N][2]))