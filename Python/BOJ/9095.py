import sys

def solution():
	dp = [0] * 11
	dp[0] = 1
	for i in range(1,11):
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
	n = int(sys.stdin.readline())
	for i in range(n):
		num = int(sys.stdin.readline())
		print(dp[num])

		
solution()