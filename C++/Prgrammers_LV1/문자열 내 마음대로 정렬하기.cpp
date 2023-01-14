#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int N;
bool cmpByIndex(string str, string str2)
{
	if (str[N] == str2[N])
		return str < str2;
	else
		return str[N] < str2[N];
}

vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
	N = n;
	sort(strings.begin(),strings.end(),cmpByIndex);
	answer = strings;
    return answer;
}

int main()
{
	vector<string> answer;
	vector<string> strings = {"sun","bed","car"};
	vector<string> strings2 = {"abce", "abcd", "cdx"};
	int		n = 2;

	answer = solution(strings2, n);
	for (int i = 0; i < answer.size();i++)
		cout << answer[i]<<endl;
}