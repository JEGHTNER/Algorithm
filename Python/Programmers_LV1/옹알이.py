def check_babble(babble):
    words = ["aya", "ye","woo","ma"]
    tmp = ""
    last = ""
    for ch in babble:
        tmp += ch
        if tmp in words:
            if last == tmp:
                return False
            last = tmp
            tmp = ""
    if len(tmp) == 0:
        return True
    return False
    
def solution(babbling):
    answer = 0
    for babble in babbling:
        answer += check_babble(babble)
    return answer