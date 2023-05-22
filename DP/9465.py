import sys

t = int(sys.stdin.readline())
for tc in range(t):
	n = int(sys.stdin.readline())
	lst=[]
	lst.append(list(map(int, sys.stdin.readline().split())))
	lst.append(list(map(int, sys.stdin.readline().split())))
	
	for i in range(1, n):
		if i == 1:
			lst[0][i] += lst[1][i - 1]
			lst[1][i] += lst[0][i - 1]
		else:
			lst[0][i] += max(lst[1][i - 1], lst[1][i - 2])
			lst[1][i] += max(lst[0][i - 1], lst[0][i - 2])
	print(max(lst[0][-1], lst[1][-1]))