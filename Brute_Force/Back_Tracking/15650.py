import sys

n, m = map(int, sys.stdin.readline().split())

lst = []

def dfs(start):
	if len(lst) == m:
		print(' '.join(map(str, lst)))
		return
	for i in range(start, n+1):
		if i not in lst:
			lst.append(i)
			dfs(i + 1)
			lst.pop()
dfs(1)