import sys
from collections import deque

A, B = map(int, sys.stdin.readline().split())

queue = deque()


def calc1(num):
    return num * 2


def calc2(num):
    return num * 10 + 1


count = 0
queue.append((A, 1))
flag = 0
while queue:
    tmp, depth = queue.popleft()
    num1 = calc1(tmp)
    num2 = calc2(tmp)
    if num1 == B or num2 == B:
        print(depth + 1)
        flag = 1
        break
    if num1 <= B:
        queue.append((num1, depth + 1))
    if num2 <= B:
        queue.append((num2, depth + 1))

if flag == 0:
    print(-1)