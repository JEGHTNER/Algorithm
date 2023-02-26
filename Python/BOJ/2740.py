import sys
AB= []
#A
N, M = map(int, sys.stdin.readline().split())
A= []
for i in range(N):
    A.append(list(map(int, sys.stdin.readline().split())))
#B
B = []
M, K = map(int, sys.stdin.readline().split())
for i in range(M):
    B.append(list(map(int, sys.stdin.readline().split())))

AB = [[0 for _ in range(K)] for _ in range(N)]

for n in range(N):
    for k in range(K):
        for m in range(M):
            AB[n][k] += A[n][m] * B[m][k]

for col in AB:
    for num in col:
        print(num, end= ' ')
    print()
