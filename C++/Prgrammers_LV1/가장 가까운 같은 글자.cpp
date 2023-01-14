#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
	map<char, int> dic;

	for (int i = 0; i < s.size(); i ++)
	{
		if (dic.find(s[i]) == dic.end())
			answer.push_back(-1);
		else
			answer.push_back(i - dic[s[i]]);
		dic[s[i]] = i;
	}
    return answer;
}

int main()
{
	vector<int> answer = solution("banana");
	for (int i = 0; i < answer.size(); i++)
	{
		cout <<answer[i]<< " ";
	}
}