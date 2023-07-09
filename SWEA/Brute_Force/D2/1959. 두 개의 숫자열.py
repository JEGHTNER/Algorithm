T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    A_len = len(A)
    B = list(map(int, input().split()))
    B_len = len(B)
    ans = -10e9
    tmp_sum = 0
    if A_len > B_len:
        for i in range(A_len - B_len + 1):
            tmp_sum = 0
            for j in range(B_len):
                tmp_sum += A[i + j] * B[j]
            ans = max(ans, tmp_sum)
    elif A_len < B_len:
        for i in range(B_len - A_len + 1):
            tmp_sum = 0
            for j in range(A_len):
                tmp_sum += A[j] * B[i + j]
            ans = max(ans, tmp_sum)
    else:
        for i in range(A_len):
            ans += A[i] * B[i]
    print("#",end = "")
    print(tc, ans)

