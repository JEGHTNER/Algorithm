import sys

N = int(sys.stdin.readline())
visited_row = [0] * 40
visited_up_cross = [0] * 40
visited_down_cross = [0] * 40

cnt = 0
def dfs(cur):
    global cnt

    if cur == N:
        cnt += 1
        return
    for i in range(N):
        if visited_row[i] or visited_up_cross[i + cur] or visited_down_cross[cur - i + N - 1]:
            continue
        visited_row[i] = 1
        visited_up_cross[i + cur] = 1
        visited_down_cross[cur - i + N - 1] = 1
        dfs(cur + 1)
        visited_row[i] = 0
        visited_up_cross[i + cur] = 0
        visited_down_cross[cur - i + N - 1] = 0

dfs(0)
print(cnt)