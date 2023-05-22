import sys
import heapq

def solution():
	n = int(sys.stdin.readline())
	pq = []
	for i in range(n):
		x = int(sys.stdin.readline())
		if (x == 0):
			if len(pq):
				print(heapq.heappop(pq))
			else:
				print(0)
		else:
			heapq.heappush(pq, x)

solution()