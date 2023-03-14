import sys

N = int(sys.stdin.readline())
lst = []
for i in range(N):
    age, name = sys.stdin.readline().rstrip().split()
    lst.append([int(age), i, name])
lst.sort()
for ans in lst:
    print(ans[0], ans[2])
