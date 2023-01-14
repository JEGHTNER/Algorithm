def solution(id_list, report, k):
    answer = []
    report = list(set(report))
    dic ={}
    reported=[]
    for name in id_list:
        dic[name] = [0,0]
    print(dic)
    for r in report:
        tmp = r.split()
        print(tmp)
        dic[tmp[0]].append(tmp[1])
        dic[tmp[1]][0] += 1

    for i in dic:
        if dic[i][0] >= k:
            reported.append(i)
    for i in dic:
        for rep in reported:
            if rep in dic[i]:
                dic[i][1] +=1
    print(dic)
    a = list(dic.values())
    for i in a:
        answer.append(i[1])
    return answer
    
id_list = ["muzi", "frodo", "apeach", "neo"]
#id_list = ["con", "ryan"]	
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	
#report = ["ryan con", "ryan con", "ryan con", "ryan con"]
print(solution(id_list, report, 2))