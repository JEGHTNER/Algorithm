import sys

N = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
find = list(map(int, sys.stdin.readline().split()))

dic = {}
for card in cards:
    if card in dic:
        dic[card] += 1
    else:
        dic[card] = 1


for f in find:
    if f in dic:
        print(dic[f], end= " ")
    else:
        print(0, end= " ")