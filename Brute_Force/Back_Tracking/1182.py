import sys

N, S = map(int, sys.stdin.readline().split())
dp = [0] * 21
cnt = 0
lst = list(map(int, sys.stdin.readline().split()))


def dfs(cur, total):
    global cnt

    if cur == N:
        if total == S:
            cnt += 1
        return
    dfs(cur + 1, total)
    dfs(cur + 1, total + lst[cur])

dfs(0, 0)
if S == 0:
    cnt -= 1
print(cnt)