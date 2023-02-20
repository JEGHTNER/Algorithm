import sys
from collections import deque

queue = deque()
n = int(sys.stdin.readline())

for _ in range(n):
    cmd = sys.stdin.readline().rstrip()
    if cmd[:4] == "push":
        queue.append(cmd.split()[1])
    elif cmd == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif cmd == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
    elif cmd == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif cmd == "size":
        print(len(queue))
    elif cmd == "empty":
        if queue:
            print(0)
        else:
            print(1)
