import sys
import heapq
N = int(sys.stdin.readline())
hq = []
for i in range(N):
    x = int(sys.stdin.readline())
    if x != 0:
        heapq.heappush(hq, [abs(x), x])
    else:
        if hq:
            tmp = heapq.heappop(hq)
            print(tmp[1])
        else:
            print(0)