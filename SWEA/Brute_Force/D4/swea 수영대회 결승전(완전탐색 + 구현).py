from collections import deque

T = int(input())

for tc in range(1, T + 1):
    arr = []
    N = int(input())
    for i in range(N):
        arr.append(list(map(int, input().split())))
    A, B = map(int, input().split())
    C, D = map(int, input().split())
    visited = [[-1] * N for _ in range(N)]
    cnt = 1


    def bfs(i, j):
        global cnt
        queue = deque()
        queue.append([i, j])
        visited[i][j] = 0
        dx = [1, 0, -1, 0]
        dy = [0, 1, 0, -1]
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= N or ny >= N:
                    continue
                # if visited[nx][ny] != -1:
                #     continue
                cnt += 1
                if arr[nx][ny] == 1:
                    continue
                if arr[nx][ny] == 2:
                    if cnt % 2 != 0:
                        visited[nx][ny] = visited[x][y] + 3
                    else:
                        visited[nx][ny] = visited[x][y] + 1
                if arr[nx][ny] == 0:
                    if visited[nx][ny] != -1:
                        if visited[nx][ny] > visited[x][y] + 1:
                            visited[nx][ny] = visited[x][y] + 1
                    else:
                        visited[nx][ny] = visited[x][y] + 1
                if nx == C and ny == D:
                    return
                queue.append([nx, ny])

    bfs(A, B)
    print("#", end ="")
    print(tc, visited[C][D])


