import sys

def solution():
    n, m = map(int, sys.stdin.readline().split())
    hear=[]
    see = []
    ans = []
    for i in range(n):
        hear.append(sys.stdin.readline().rstrip())
    for j in range(m):
        see.append(sys.stdin.readline().rstrip())
    ans = set(hear) & set(see)
    ans = sorted(list(ans))
    print(len(ans))
    for a in ans:
        print(a)
    return ans


solution()