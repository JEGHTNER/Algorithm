import sys

N, M = map(int, sys.stdin.readline().split())

dic = {}
for _ in range(N):
    addr, pwd = sys.stdin.readline().split()
    dic[addr] = pwd

for i in range(M):
    find = sys.stdin.readline().rstrip()
    print(dic[find])
