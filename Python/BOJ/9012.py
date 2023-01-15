import sys

def solution():
    N = int(sys.stdin.readline())
    answer = []
    for i in range(N):
        parenthesis = sys.stdin.readline().strip()
        stack = []
        for p in parenthesis:
            stack.append(p)
            if len(stack) > 1 and stack[-2:] == ['(', ')']:
                del stack[-2:]
        #print(stack)
        if (len(stack) != 0):
            print("NO")
        else:
            print("YES")

solution()