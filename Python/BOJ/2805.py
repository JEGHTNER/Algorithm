import sys

N, M = map(int, sys.stdin.readline().split())

trees = list(map(int, sys.stdin.readline().split()))
dp = [0 for _ in range(N + 1)]

def binary_search(trees, start, end):
    res = 0
    while start <= end:
        mid = (start+end) // 2
        total = 0
        
        for x in trees:
            if x > mid:
                total+= x- mid
            
        if total < M:
            end = mid-1
        else:
            res = mid
            start = mid +1
    return res

print(binary_search(trees, 0, max(trees)))