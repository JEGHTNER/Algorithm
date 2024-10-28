import sys

n, m = map(int, sys.stdin.readline().split())
ans = 0

arr=[ [0 for _ in range(m)] for _ in range(n)]

for i in range(n):
    line = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        arr[i][j] = line[j]
        if arr[i][j] == 1:
            ans+=1

L1, R1 = map(int, sys.stdin.readline().split())
L2, R2 = map(int, sys.stdin.readline().split())

for i in range(L1 - 1, R1):
    for j in range(m):
        if arr[i][j] == 1:
            arr[i][j] = 0
            ans -= 1
            break

for i in range(L2 - 1, R2):
    for j in range(m):
        if arr[i][j] == 1:
            arr[i][j] = 0
            ans -= 1
            break

print(ans)
    
    
