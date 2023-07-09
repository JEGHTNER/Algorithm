from collections import Counter

T = int(input())

for tc in range(1, T + 1):
    tc = int(input())
    nums = list(map(int, input().split()))
    nums.sort(reverse=True)
    print("#", end="")
    print(tc, Counter(nums).most_common()[0][0])
