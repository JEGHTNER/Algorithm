import sys

N = int(sys.stdin.readline())
road = list(map(int, sys.stdin.readline().split()))
price = list(map(int, sys.stdin.readline().split()))
ans = 0
min_price = price[0]
for i in range(N - 1):
    min_price = min(min_price, price[i])
    ans += min_price * road[i]

print(ans)
