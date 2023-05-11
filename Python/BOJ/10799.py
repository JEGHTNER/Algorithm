import sys
import math

string = sys.stdin.readline().rstrip()
stack = []
answer = 0
for i in range(len(string)):
    if string[i] == '(':
        stack.append('(')
    else:
        if string[i - 1] == '(':
            stack.pop()
            answer += len(stack)
        else:
            stack.pop()
            answer += 1
print(answer)