import sys
from collections import deque
T = int(sys.stdin.readline())

for tc in range(T):
    A, B = map(int, sys.stdin.readline().rstrip().split())
    visited = [0] * 10001
    def calc(cmd, num):
        if cmd == 'D':
            return num * 2 % 10000
        elif cmd == 'S':
            return (num - 1) % 10000
        elif cmd == 'L':
            tmp = num // 1000
            return num % 1000 * 10 + tmp
        elif cmd == 'R':
            tmp = num % 10
            return num // 10 + 1000 * tmp
    def bfs():
        queue = deque()
        ans = ""
        queue.append([A, ans])
        while queue:
            tmp = queue.popleft()
            ans = tmp[1]
            if tmp[0] == B:
                print(ans)
                break
            if visited[calc('L', tmp[0])] == 0:
                visited[calc('L', tmp[0])] = 1
                queue.append([calc('L', tmp[0]), ans + 'L'])
            if visited[calc('R', tmp[0])] == 0:
                visited[calc('R', tmp[0])] = 1
                queue.append([calc('R', tmp[0]), ans + 'R'])
            if visited[calc('D', tmp[0])] == 0:
                visited[calc('D', tmp[0])] = 1
                queue.append([calc('D', tmp[0]), ans + 'D'])
            if visited[calc('S', tmp[0])] == 0:
                visited[calc('S', tmp[0])] = 1
                queue.append([calc('S', tmp[0]), ans + 'S'])
    bfs()
