import sys
import math

N = int(sys.stdin.readline())

def round2(num):
    return int(num) + (1 if num - int(num) >= 0.5 else 0)

def solution():
    if N == 0:
        print(0)
        return
    low_average = round2(N * 15 / 100)
    ans = 0
    lst = []

    for i in range(N):
        lst.append(int(sys.stdin.readline()))
    lst.sort()
    trunc_lst = lst[low_average : N - low_average]
    for num in trunc_lst:
        ans += num

    print(round2(ans/len(trunc_lst)))

solution()