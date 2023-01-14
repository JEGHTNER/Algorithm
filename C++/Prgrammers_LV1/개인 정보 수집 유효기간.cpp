#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <map>
using namespace std;


vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
    return answer;
}

int	check_date(vector<string> date, string c_date, int num)
{
	vector<string> _date = split(c_date, '.');
	int year = stoi(date[0]);
	int	month = stoi(date[1]);
	int	day = stoi(date[2]);
	int _year = stoi(_date[0]);
	int	_month = stoi(_date[1]);
	int	_day = stoi(_date[2]);

	_month += num;
	while (_month > 12)
	{
		_year++;
		_month -= 12;
	}
	if (year > _year)
		return 0;
	else if (year == _year)
	{
		if (month > _month)
			return 0;
		else if (month == _month)
		{
			if (day >= _day)
				return 0;
		}
	}
	return 1;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int>				answer;
	vector<string>	date = split(today, '.');
	map<string, int>		dic;
	int idx = 0;
	
	for (auto t : terms)
	{
		vector<string> tmp = split(t, ' ');
		dic[tmp[0]] = stoi(tmp[1]);
	}
	for (auto p : privacies)
	{
		vector<string> tmp = split(p, ' ');
		if (check_date(date, tmp[0], dic[tmp[1]]) == 0)
			answer.push_back(idx+1);
		idx++;
	}
    return answer;
}


#include "printVector.cpp"
int  main()
{
	string today = "2022.05.19"	;
	vector<string> terms = {"A 6", "B 12", "C 3"};
	vector<string> privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
	printVector(solution(today, terms, privacies));
}