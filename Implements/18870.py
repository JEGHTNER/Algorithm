import sys

def solution():
	n = int(sys.stdin.readline())
	num = list(map(int, sys.stdin.readline().split()))
	s_num = sorted(list(set(num)))
	dic = {s_num[i] : i for i in range(len(s_num))}
	for i in num:
		print(dic[i], end = " ")
	print()
solution()