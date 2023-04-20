import sys

N = int(sys.stdin.readline())

dp = [0] * 1001

dp[1] = 1
dp[2] = 3

for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007

print(dp[N])