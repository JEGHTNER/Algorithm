def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report = list(set(report))
    dic = {x : 0 for x in id_list}

    for r in report:
        tmp = r.split()[1]
        #print(tmp)
        dic[tmp] += 1
    #print(dic)
    for r in report:
        if dic[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1
    return answer
    
id_list = ["muzi", "frodo", "apeach", "neo"]
#id_list = ["con", "ryan"]	
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	
#report = ["ryan con", "ryan con", "ryan con", "ryan con"]
print(solution(id_list, report, 2))