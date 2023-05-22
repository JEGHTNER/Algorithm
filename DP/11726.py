import sys

def solution():
    dp = [0] * 1001
    dp[1] = 1
    dp[2] = 2
    n = int(sys.stdin.readline())
    for i in range(3, n + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    print(dp[n] % 10007)

solution()