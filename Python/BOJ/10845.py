import sys
from collections import deque

N = int(sys.stdin.readline())
queue = deque()
for i in range(N):
    cmd = sys.stdin.readline().rstrip()
    if cmd[0:4] == "push":
        queue.append(cmd.split()[1])
    elif cmd[0:3] == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif cmd[0:4] == "size":
        print(len(queue))
    elif cmd[0:5] == "empty":
        if queue:
            print(0)
        else:
            print(1)
    elif cmd[0:5] == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif cmd[0:4] == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)

