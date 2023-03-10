import sys

K, N = map(int, sys.stdin.readline().split())
lst = [int(sys.stdin.readline()) for _ in range(K)]
max_len = 0
def binarySearch(lst, start, end):
    res = 0
    while start <= end:
        mid = (start+end) // 2
        sum = 0

        for num in lst :
            sum += num // mid

        if sum < N:
            end = mid - 1
        else:
            res = mid
            start = mid + 1

    return res
print(binarySearch(lst,1,max(lst)))
