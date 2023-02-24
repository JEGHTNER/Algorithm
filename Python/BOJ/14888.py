import sys
from itertools import permutations as pm

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
calc_num = list(map(int, sys.stdin.readline().split()))
calc = []
min_sum = 1e9
max_sum = -1e9
for i in range(len(calc_num)):
    for j in range(calc_num[i]):
        if i == 0:
            calc.append('+')
        elif i == 1:
            calc.append('-')
        elif i == 2:
            calc.append('x')
        elif i == 3:
            calc.append('/')

perm = list(pm(calc, n - 1))
for p in perm:
    tmp_sum = a[0]
    for i in range(n - 1):
        if p[i] == '+':
            tmp_sum += a[i + 1]
        elif p[i] == '-':
            tmp_sum -= a[i + 1]
        elif p[i] == 'x':
            tmp_sum *= a[i + 1]
        elif p[i] == '/':
            if tmp_sum < 0:
                tmp_sum *= -1
                tmp_sum //= a[i + 1]
                tmp_sum *= -1
            else:
                tmp_sum //= a[i + 1]
    max_sum = max(tmp_sum, max_sum)
    min_sum = min(tmp_sum, min_sum)
print(max_sum)
print(min_sum)