import sys
import heapq
def solution():
    heap = []
    n = int(sys.stdin.readline())
    for i in range(n):
        num = int(sys.stdin.readline())
        if num == 0:
            if heap:
                print(heapq.heappop(heap)[1])
            else:
                print(0)
        else:
            heapq.heappush(heap, (-num, num))


solution()