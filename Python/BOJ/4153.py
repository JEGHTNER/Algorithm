import sys

def solution():
	while 1:
		a, b, c = map(int, sys.stdin.readline().split())
		if a == 0 and b == 0 and c == 0:
			return
		m = max(a, b, c)
		if a == m:
			if a * a == b * b + c * c:
				print("right")
			else:
				print("wrong")
		elif b == m:
			if b * b == a * a + c * c:
				print("right")
			else:
				print("wrong")
		elif c == m:
			if c * c == a * a + b * b:
				print("right")
			else:
				print("wrong")


solution()