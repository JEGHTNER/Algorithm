import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())

def bfs():
	visits =[0] * 100001
	queue = deque()
	queue.append(n)
	while queue:
		x = queue.popleft()
		if x == k:
			print(visits[x])
			break
		for nx in [x - 1, x + 1, x * 2]:
			if 0 <= nx <= 100000 and not visits[nx]: 
				visits[nx] = visits[x] + 1
				queue.append(nx)

bfs()