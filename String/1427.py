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
    ret = quicksort(right) + mid + quicksort(left)
    return ret

def solution():
    n = int(sys.stdin.readline())
    _n = list(map(int, list(str(n))))
    #print(_n)
    ret = quicksort(_n)
    print(''.join(list(map(str, ret))))

solution()