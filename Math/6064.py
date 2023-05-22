import sys

T = int(sys.stdin.readline())


def calc(M, N, x, y):
    while x <= M * N:
        if (x - y) % N == 0:
            return (x)
        x += M
    return (-1)


for tc in range(T):
    M, N, x, y = map(int, sys.stdin.readline().split())
    print(calc(M, N, x, y))

# fail approach
# cnt = 0
# fail = 0
# _x, _y = 1, 1
# while True:
#     cnt += 1
#     if _x == x and _y == y:
#         break
#     if _x == M and _y == N and x != M and y != N:
#         fail = 1
#         break
#     if _x < M:
#         _x = _x + 1
#     else:
#         _x = 1
#     if _y < N:
#         _y = _y + 1
#     else:
#         _y = 1
# if fail == 1:
#     print(-1)
# else:
#     print(cnt)
