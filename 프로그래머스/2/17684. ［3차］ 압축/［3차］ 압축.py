def solution(msg):
    answer = []
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    dict = {}
    cnt = 1
    for c in alphabet:
        dict[c]=cnt
        cnt+=1
    idx = 0
    while idx < len(msg):
        # 현재 입력과 일치하는 가장 긴 문자열 w
        w = msg[idx]
        # print(w)
        sliced=msg[idx+1:]
        # print("sliced=",sliced)
        tmp = ""
        j = 1
        for c in sliced:
            if w + tmp + c not in dict:
                dict[w+tmp + c]=cnt
                cnt+=1
                break
            j+=1
            tmp += c
        answer.append(dict[msg[idx:idx+j]])
        idx+=j
    # print(answer)
    return answer