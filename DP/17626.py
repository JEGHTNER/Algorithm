import sys
import math


# N = int(sys.stdin.readline())
# dp = [0, 1]
#
# for i in range(2, N + 1):
#     min_val = 1e9
#     for j in range(1, int(math.sqrt(i)) + 1):
#         min_val = min(min_val, dp[i - j ** 2])
#     dp.append(min_val + 1)
# print(dp[N])

N = int(sys.stdin.readline())

def four_squares(num):
    if math.sqrt(N).is_integer():
        return 1
    squares = {i ** 2 for i in range(1, int(math.sqrt(N)) + 1)}

    for s in squares:
        if N - s in squares:
            return 2
    for s1 in squares:
        for s2 in squares:
            if N - s1 - s2 in squares:
                return 3

    return 4

print(four_squares(N))

