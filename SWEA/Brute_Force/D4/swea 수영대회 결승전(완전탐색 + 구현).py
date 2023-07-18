from collections import deque

T = int(input())

for tc in range(1, T + 1):
    arr = []
    N = int(input())
    for i in range(N):
        arr.append(list(map(int, input().split())))
    A, B = map(int, input().split())
    C, D = map(int, input().split())
    ans = 10e9
    visited = [[0] * N for _ in range(N)]

    def bfs(i, j):
        global ans
        cnt = 0
        tornado = [2, 1, 0]
        queue = deque()
        queue.append([i, j, 0])
        visited[i][j] = 0
        dx = [1, 0, -1, 0]
        dy = [0, 1, 0, -1]
        while queue:
            x, y, now = queue.popleft()
            visited[x][y] = now
            if (x, y) == (C, D):
                ans = min(ans, now)
                continue
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= N or ny >= N:
                    continue
                if arr[nx][ny] == 1:
                    continue
                if visited[nx][ny]:
                    continue
                next_time = now
                if arr[nx][ny] == 2 and (now - 2) % 3 != 0:
                    while (next_time - 2) % 3 != 0:
                        next_time += 1
                queue.append([nx, ny, next_time + 1])

    bfs(A, B)
    print("#", end ="")
    print(tc, ans)

