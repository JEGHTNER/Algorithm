import sys
from itertools import permutations

N, K = map(int, sys.stdin.readline().split())
kit = list(map(int, sys.stdin.readline().split()))
perm = list(permutations(kit, len(kit)))
cnt = 0
for p in perm:
    tmp = 500
    fail = 0
    for i in p:
        tmp += i
        tmp -= K
        if tmp < 500:
            fail = 1
            break
    if fail == 0:
        cnt += 1

print(cnt)
