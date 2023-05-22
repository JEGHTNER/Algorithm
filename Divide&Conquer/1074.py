import sys

n, r, c = map(int, sys.stdin.readline().split())

def recur(n, y, x):
	global count

	if y == r and x == c:
		print(int(count))
		exit(0)	
	if n == 1:
		count += 1
		return

	if not (y <= r < y + n and x <= c < x + n):
		count += n * n
		return
	recur(n / 2, y, x)
	recur(n / 2, y, x + n / 2)
	recur(n / 2, y + n / 2, x)
	recur(n / 2, y + n / 2, x + n / 2)
	
def solution():
	global count
	count = 0
	recur(2 ** n, 0, 0)
	#print(table[r][c])


solution()