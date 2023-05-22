import sys

def factorial(m):
	ans = 1
	for i in range(m):
		ans *= (m - i)
	return (ans)

def nPm(n, m):
	ans = 1
	for i in range(m):
		ans *= (n - i)
	return ans

def nCm(n, m):
	ans = nPm(n, m) // factorial(m)
	return (ans)

n, m = map(int, sys.stdin.readline().split())

print(nCm(n, m))