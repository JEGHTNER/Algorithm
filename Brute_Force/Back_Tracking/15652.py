import sys

n, m = map(int, sys.stdin.readline().split())
lst = []


def dfs(start):
    if len(lst) == m:
        print(' '.join(map(str, lst)))
        return
    for i in range(1, n + 1):
        if (i >= start):
            lst.append(i)
            dfs(i)
            lst.pop()

dfs(1)
