import sys

def solution():
    n = int(sys.stdin.readline().strip())
    lst = []
    for i in range(n):
        s = sys.stdin.readline().strip()
        lst.append(s)
    lst = sorted(list(set(lst)))
    result = sorted(lst, key = len)
    for i in result:
        print(i)

solution()