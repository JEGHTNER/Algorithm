import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

queue = deque()
answer = []
for i in range(1, N + 1):
    queue.append(i)

while queue:
    for i in range(K - 1):
        queue.append(queue.popleft())
    answer.append(queue.popleft())

print("<", end="")
for i in answer:
    if i != answer[-1]:
        print(i,end = ", ")
    else:
        print(i, end = "")
print(">")