import sys

N = int(sys.stdin.readline())
lst = []
for i in range(N):
    lst.append(list(map(int, sys.stdin.readline().split())))
lst.sort()
lst.sort(key = lambda a: a[1])
for l in lst:
    for num in l:
        print(num, end= " ")
    print()