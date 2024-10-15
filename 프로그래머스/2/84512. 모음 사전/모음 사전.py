cnt = -1
answer = 0

def dfs(depth, word, cur):
    # print(cur)
    global cnt
    global answer
    cnt +=1
    if word == cur:
        answer = cnt
    if depth == 6:
        return
    dfs(depth + 1, word, cur + "A")
    dfs(depth + 1, word, cur + "E")
    dfs(depth + 1, word, cur + "I")
    dfs(depth + 1, word, cur + "O")
    dfs(depth + 1, word, cur + "U")
    

def solution(word):
    global answer
    dfs(1, word, "")
    print(answer)
    return answer