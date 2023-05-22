import sys

def solution():
    n = int(sys.stdin.readline().strip())
    dp = [0 for i in range(n + 1)]
    lst = list(map (int, sys.stdin.readline().split()))
    sum = 0
    lst.sort()
    for i in range(len(lst)):
        dp[i] += lst[i]
        dp[i] += dp[i - 1]
        sum += dp[i]
    print(sum)

solution()