import sys

T = int(sys.stdin.readline())

dp = [0] * 101
dp[0] = 1
dp[1] = 1
dp[2] = 1
for i in range(3, 101):
    dp[i] = dp[i - 3] + dp[i - 2]
for i in range(T):
    N = int(sys.stdin.readline())
    print(dp[N - 1])
