import math
import sys
from collections import deque

N = sys.stdin.readline().strip()

num = {i : 0 for i in range(10)}
for c in N:
    num[int(c)] += 1
tmp1 = num[6]
tmp2 = num[9]
num[6] = math.ceil((tmp1 + tmp2) / 2)
num[9] = math.ceil((tmp1 + tmp2) / 2)
print(max(num.values()))