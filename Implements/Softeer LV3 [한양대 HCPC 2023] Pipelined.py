import sys

N = int(sys.stdin.readline())
line = list(map(int, sys.stdin.readline().split()))

line.sort()
print(line[-1] + len(line)-1)
