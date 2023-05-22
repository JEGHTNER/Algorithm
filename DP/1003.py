import sys

def solution():
    dp = [[] for i in range(41)]
    dp[0] = [1,0]
    dp[1] = [0,1]
    for i in range(2, 41):
        dp[i] = [dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]]
    t = int(sys.stdin.readline().strip())
    for i in range(t):
        n = int(sys.stdin.readline().strip())
        for num in dp[n]:
            print(num, end=' ')
        print()
solution()