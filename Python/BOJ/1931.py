import sys

n = int(sys.stdin.readline())
lst = []
cnt = 0
e_t = 0
for i in range(n):
    start, end = map(int, sys.stdin.readline().split())
    lst.append([start, end])
lst.sort(key= lambda x : [x[1], x[0]])
for start, end in lst:
    if start >= e_t:
        cnt += 1
        e_t = end

print(cnt)
