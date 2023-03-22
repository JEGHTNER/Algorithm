import sys
import math

N = int(sys.stdin.readline())

num = math.factorial(N)
num = str(num)
count = 0
for i in range(len(num) - 1, -1, -1):
    if num[i] == "0":
        count += 1
    else:
        break
print(count)