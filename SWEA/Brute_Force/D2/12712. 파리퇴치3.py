T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())
    arr = []
    ans = -10e9
    for i in range(N):
        arr.append(list(map(int, input().split())))


    def calc_1(x, y):
        ret = arr[x][y]
        #left
        for i in range(1, M):
            nx = x - i
            if nx < 0:
                continue
            ret += arr[nx][y]
        #right
        for i in range(1, M):
            nx = x + i
            if N <= nx:
                continue
            ret += arr[nx][y]
        #up
        for i in range(1, M):
            ny = y - i
            if ny < 0:
                continue
            ret += arr[x][ny]
        #down
        for i in range(1, M):
            ny = y + i
            if N <= ny:
                continue
            ret += arr[x][ny]
        return ret


    def calc_2(x, y):
        ret = arr[x][y]
        #left_up
        for i in range(1, M):
            nx, ny = x - i, y - i
            if nx < 0 or ny < 0:
                continue
            ret += arr[nx][ny]
        #right_down
        for i in range(1, M):
            nx, ny = x + i, y + i
            if N <= nx or N <= ny:
                continue
            ret += arr[nx][ny]
        #left_down
        for i in range(1, M):
            nx, ny = x - i, y + i
            if nx < 0 or N <= ny:
                continue
            ret += arr[nx][ny]
        #right_up
        for i in range(1, M):
            nx, ny = x + i, y - i
            if N <= nx or ny < 0:
                continue
            ret += arr[nx][ny]
        return ret


    for i in range(N):
        for j in range(N):
            ans = max(ans, max(calc_1(i, j), calc_2(i, j)))
    print("#", end="")
    print(tc, ans)