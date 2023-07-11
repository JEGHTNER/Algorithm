from collections import Counter

T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    arr = []
    for i in range(N):
        arr.append(list(input().strip().split()))
    rotate_90 = [[] for _ in range(N)]
    rotate_180 = [[] for _ in range(N)]
    rotate_270 = [[] for _ in range(N)]

    for i in range(N):
        for j in range(N):
            rotate_90[i].append(arr[N - 1 - j][i])
            rotate_180[i].append(arr[N - 1 - i][N - 1 - j])
            rotate_270[i].append(arr[j][N - 1 - i])
    print("#", end = "")
    print(tc)
    for i in range(N):
        print(''.join(rotate_90[i]), end=" ")
        print(''.join(rotate_180[i]), end= " ")
        print(''.join(rotate_270[i]))

