import sys
from itertools import permutations as pm

# first solution
# n = int(sys.stdin.readline())
# a = list(map(int, sys.stdin.readline().split()))
# calc_num = list(map(int, sys.stdin.readline().split()))
# calc = []
# min_sum = 1e9
# max_sum = -1e9
# for i in range(len(calc_num)):
#     for j in range(calc_num[i]):
#         if i == 0:
#             calc.append('+')
#         elif i == 1:
#             calc.append('-')
#         elif i == 2:
#             calc.append('x')
#         elif i == 3:
#             calc.append('/')

# perm = list(pm(calc, n - 1))
# for p in perm:
#     tmp_sum = a[0]
#     for i in range(n - 1):
#         if p[i] == '+':
#             tmp_sum += a[i + 1]
#         elif p[i] == '-':
#             tmp_sum -= a[i + 1]
#         elif p[i] == 'x':
#             tmp_sum *= a[i + 1]
#         elif p[i] == '/':
#             if tmp_sum < 0:
#                 tmp_sum *= -1
#                 tmp_sum //= a[i + 1]
#                 tmp_sum *= -1
#             else:
#                 tmp_sum //= a[i + 1]
#     max_sum = max(tmp_sum, max_sum)
#     min_sum = min(tmp_sum, min_sum)
# print(max_sum)
# print(min_sum)

# second solution
n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
calc_num = list(map(int, sys.stdin.readline().split()))

max_sum = -1e9
min_sum = 1e9

def dfs(depth, tmp_sum, plus, minus, mul, div):
    global max_sum, min_sum
    if depth == n:
        max_sum = max(tmp_sum, max_sum)
        min_sum = min(tmp_sum, min_sum)
        return
    
    if plus:
        dfs(depth + 1, tmp_sum + a[depth], plus - 1, minus, mul, div)
    if minus:
        dfs(depth + 1, tmp_sum - a[depth], plus, minus - 1, mul, div)
    if mul:
        dfs(depth + 1, tmp_sum * a[depth], plus, minus, mul - 1, div)
    if div:
        dfs(depth + 1, int(tmp_sum / a[depth]), plus, minus, mul, div - 1)

dfs(1, a[0], calc_num[0], calc_num[1], calc_num[2], calc_num[3])
print(max_sum)
print(min_sum)
