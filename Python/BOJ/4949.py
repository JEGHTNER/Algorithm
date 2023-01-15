import sys

def solution():
    dic={')': '(', ']': '['}
    while (1):
        l_stack = []
        r_stack = []
        top = 'e'
        string = input()
        if string == ".":
            break
        for ch in string:
            if ch in ['(', '[']:
                l_stack.append(ch)
                top = ch
            if ch in dic:
                r_stack.append(ch)
                if top == dic[ch]:
                    l_stack.pop()
                    r_stack.pop()
                    if len(l_stack) > 0:
                        top = l_stack[-1]
                    else:
                        top = 'e'
        if len(l_stack) == 0 and len(r_stack) == 0:
            print("yes")
        else:
            print("no")

solution()