import sys
from collections import deque

def bfs(table, width, height):
    queue = deque()
    for i in range(height):
        for j in range(width):
            if table[i][j] == 1:
                queue.append([i, j, 0])

    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    while queue:
        y, x, count = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            ncount = count + 1

            if 0 <= nx < width and 0 <= ny < height:
                if table[ny][nx] == 0:
                    table[ny][nx] = 1
                    queue.append([ny, nx, ncount])
    for i in range(height):
        if table[i].count(0) != 0:
            count = -1
            break
    print(count)


def solution():
    width, height = map(int, sys.stdin.readline().split())
    table = [list(map(int, sys.stdin.readline().split())) for _ in range(height)]
    #print(table)
    bfs(table, width, height)


solution()