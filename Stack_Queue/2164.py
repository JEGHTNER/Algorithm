import sys
from collections import deque


n = int(sys.stdin.readline())

queue = deque(i for i in range(1, n + 1))

while queue:
    if len(queue) <= 1:
        break
    queue.popleft()
    tmp = queue.popleft()
    queue.append(tmp)

print(queue[0])
