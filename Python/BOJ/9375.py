import sys

#first sol
t = int(sys.stdin.readline())

for tc in range(t):
    N = int(sys.stdin.readline())
    dic = {}
    clothes = []
    kinds = []
    for i in range(N):
        cloth, kind = sys.stdin.readline().strip().split()
        if kind in dic:
            dic[kind].append(cloth)
        else:
            dic[kind] = [cloth]

    cnt = 1
    for k in dic:
        cnt *= (len(dic[k]) + 1)
    print(cnt -1)

# from collections import Counter
# 
# t = int(sys.stdin.readline())
# 
# for tc in range(t):
#     N = int(sys.stdin.readline())
#     wear = []
#     for i in range(N):
#         cloth, kind = sys.stdin.readline().strip().split()
#         wear.append(kind)
# 
#     wear_Counter = Counter(wear)
#     cnt = 1
# 
#     for key in wear_Counter:
#         cnt *= wear_Counter[key] + 1
#     print(cnt -1)