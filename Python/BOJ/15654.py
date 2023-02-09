import sys

n, m = map(int, sys.stdin.readline().split())

nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
lst = []
def dfs():
    if len(lst) == m:
        print(' '.join(map(str, lst)))
        return
    for i in nums:
        if i not in lst:
            lst.append(i)
            dfs()
            lst.pop()

dfs()