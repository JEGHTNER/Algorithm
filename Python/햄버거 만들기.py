def solution(ingredient):
    stack = []
    cnt = 0
    for i in ingredient:
        stack.append(i)
        if stack[-4:] == [1, 2, 3, 1]:
            cnt += 1
            del stack[-4:]
    return cnt