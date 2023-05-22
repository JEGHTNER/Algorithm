import sys

def quicksort(lst):
    if len(lst) <= 1:
        return lst
    pivot = lst[len(lst)//2]
    left, mid, right = [], [], []
    for num in lst:
        if num < pivot:
            left.append(num)
        elif num > pivot:
            right.append(num)
        else:
            mid.append(num)
    ret = quicksort(left) + mid + quicksort(right)
    return ret

def quicksort_reversed(lst):
    if len(lst) <= 1:
        return lst
    pivot = lst[len(lst)//2]
    left, mid, right = [], [], []
    for num in lst:
        if num > pivot:
            left.append(num)
        elif num < pivot:
            right.append(num)
        else:
            mid.append(num)
    ret = quicksort_reversed(left) + mid + quicksort_reversed(right)
    return ret

def solution():
    n = int(sys.stdin.readline().rstrip())
    a, b= [], []
    ans = 0
    a = list(map(int, sys.stdin.readline().split()))
    b = list(map(int, sys.stdin.readline().split()))
    a= quicksort(a)
    b= quicksort_reversed(b)
    for i in range(n):
        ans += a[i] * b[i]

    print(ans)
    return ans


solution()