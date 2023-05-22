import sys
from collections import deque

TC = int(sys.stdin.readline())

for tc in range(TC):
    N, M = map(int, sys.stdin.readline().split())
    queue = deque()
    max_vals = list(map(int, sys.stdin.readline().split()))
    count = 0
    for i in range(N):
        queue.append([i,max_vals[i]])
    max_vals.sort()
    max_val = max_vals[-1]
    while queue:
        popped = queue.popleft()
        if popped[0] == M and popped[1] == max_val:
            count += 1
            break
        if popped[1] == max_val:
            max_vals.pop()
            max_val = max_vals[-1]
            count += 1
        else:
            queue.append(popped)
    print(count)
