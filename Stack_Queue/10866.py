import sys
from collections import deque

n = int(sys.stdin.readline())
queue = deque()
for i in range(n):
    inp = sys.stdin.readline().rstrip()
    if inp[:4] == "push":
        cmd, num = inp.split()
        if cmd[-4:] == "back":
            queue.append(int(num))
        elif cmd[-5:] == "front":
            queue.appendleft(int(num))
    elif inp[:3] == "pop":
        if queue:
            if inp[-5:] == "front":
                print(queue.popleft())
            elif inp[-4:] == "back":
                print(queue.pop())
        else:
            print(-1)
    elif inp == "size":
        print(len(queue))
    elif inp == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif inp == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
    elif inp =="empty":
        if queue:
            print(0)
        else:
            print(1)

