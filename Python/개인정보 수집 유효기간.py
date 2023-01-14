def init_date(today):
	global year
	global month
	global day
	year = int(today[0:4])
	month = int(today[5:7])
	day = int(today[8:10])

def check_date(date, num):
	_year = int(date[0:4])
	_month = int(date[5:7])
	_day = int(date[8:10])
	_month += num
	while _month > 12:
		_year += 1
		_month -= 12
	print(year,month,day)
	print(_year,_month,_day)
	if year > _year:
		return False
	elif year == _year:
		if month > _month:
			return False
		elif month == _month :
			if day >= _day :
				return False
	return True
	
def solution(today, terms, privacies):
	answer = []
	ret = []
	dic = {}
	init_date(today)
	for t in terms:
		dic[t.split()[0]] = int(t.split()[1])
	for date in privacies:
		answer.append(check_date(date.split()[0], dic[date.split()[1]]))
		print(answer)
	for i in range(len(answer)):
		if answer[i] == False:
			ret.append(i+1)
	print(dic)
	return ret



today ="2022.05.19"	
terms = ["A 6", "B 12", "C 3"]	
privacies=["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	

print(solution(today, terms, privacies))