import sys
from itertools import combinations
T = int(sys.stdin.readline())

def trial_distance(x, y):
    ret = 0
    for i in range(4):
        if x[i] != y[i]:
            ret += 1
    return ret
def calc_mind(A, B, C):
    return trial_distance(A, B) + trial_distance(B, C) + trial_distance(A, C)

for tc in range(T):
    min_val = 10e9
    N = int(sys.stdin.readline())
    lst = list(sys.stdin.readline().rstrip().split())
    if N > 32:
        print(0)
        continue
    comb = list(combinations(lst, 3))
    for c in comb:
        tmp = calc_mind(c[0],c[1],c[2])
        if min_val > tmp:
            min_val = tmp
    print(min_val)