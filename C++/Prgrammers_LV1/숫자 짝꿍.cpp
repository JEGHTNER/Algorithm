#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

string solution(string X, string Y) {
    string answer = "";
	for(int i = 9; i >= 0; i--)
	{
		char num = i +'0';
		int x_count = count(X.begin(), X.end(), num);
		int y_count = count(Y.begin(), Y.end(), num);
		for (int j = 0; j < min(x_count, y_count); j++)
			answer += num;		
	}
	if (answer == "")
		return ("-1");
	if (answer.size() == count(answer.begin(), answer.end(),'0'))
		return ("0");
    return answer;
}

int main()
{
	string X = "5525";
	string Y = "1255";
	cout << solution(X,Y);
}