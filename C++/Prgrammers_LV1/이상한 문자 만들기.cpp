#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s) {
    string answer = "";
	int	index = 0;
	for (int i = 0; i < s.size(); i++)
	{
		if (s[i] != ' '){
			if (index % 2 == 0)
				answer += toupper(s[i]);
			else
				answer += tolower(s[i]);
			index++;
		}
		else
		{
			answer += s[i];
			index = 0;
		}
	}
    return answer;
}

int main()
{
	char *str = "try hello world";
	cout << solution(str)<<endl;
}