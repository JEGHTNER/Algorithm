import sys

N, M = map(int, sys.stdin.readline().split())
party = []
know_people = set(list(map(int,sys.stdin.readline().split()[1:])))

for _ in range(M):
    party.append(set(list(map(int, sys.stdin.readline().split()[1:]))))

for _ in range(M):
    for p in party:
        if p & know_people:
            know_people = know_people.union(p)

cnt = 0
for p in party:
    if p & know_people:
        continue
    cnt += 1
print(cnt)