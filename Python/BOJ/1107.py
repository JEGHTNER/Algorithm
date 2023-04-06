import sys

N = sys.stdin.readline().rstrip()
M = int(sys.stdin.readline())

broken = []
if (M > 0):
    broken = list(map(int, sys.stdin.readline().split()))

min_diff = abs(100 - int(N))
for i in range(1000001):
    num = str(i)
    for j in num:
        if int(j) in broken:
            break
    else:
        min_diff = min(min_diff, len(num) + abs(int(N) - int(num)))
print(min_diff)