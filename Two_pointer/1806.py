import sys
from itertools import combinations

N, S = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))

left, right = 0, 0
sums = 0
min_length = sys.maxsize

while True:
    if sums >= S:
        min_length = min(min_length, right - left)
        sums -= nums[left]
        left += 1
    elif right == N:
        break
    else:
        sums += nums[right]
        right += 1
if min_length == sys.maxsize:
    print(0)
else:
    print(min_length)
