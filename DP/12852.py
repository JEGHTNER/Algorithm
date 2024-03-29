import sys

N = int(sys.stdin.readline())

dp = [0] * (N + 1)
pre = [0] * (N + 1)

dp[1] = 0

for i in range(2, N + 1):
    dp[i] = dp[i - 1] + 1
    pre[i] = i - 1

    if i % 2 == 0 and dp[i] > dp[i//2] + 1:
        dp[i] = dp[i//2] + 1
        pre[i] = i//2
    if i % 3 == 0 and dp[i] > dp[i//3] + 1:
        dp[i] = dp[i//3] + 1
        pre[i] = i//3

cur = N
print(dp[N])
while True:
    print(cur, end= " ")
    if cur == 1:
        break
    cur = pre[cur]
