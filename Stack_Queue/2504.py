import sys

string = sys.stdin.readline().rstrip()
stack = []
length = len(string)

tmp = 1
result = 0

for i in range(length):
    c = string[i]
    if c == '(':
        tmp *= 2
        stack.append(c)
    elif c == '[':
        tmp *= 3
        stack.append(c)
    elif c == ')':
        if not stack or stack[-1] == '[':
            result = 0
            break
        if string[i - 1] == '(':
            result += tmp
        tmp //= 2
        stack.pop()
    else:
        if not stack or stack[-1] == '(':
            result = 0
            break
        if string[i - 1] == '[':
            result += tmp
        tmp //= 3
        stack.pop()
if stack:
    result = 0
print(result)