import sys

def solution():
    n, m = map(int, sys.stdin.readline().split())
    dic_name={}
    dic_num= {}
    for i in range(1, n + 1):
        s = sys.stdin.readline().strip()
        dic_num[i] = s
        dic_name[s] = i
    for j in range(m):
        ans = sys.stdin.readline().strip()
        if ans.isdigit():
            print(dic_num[int(ans)])
        else:
            print(dic_name[ans])


solution()