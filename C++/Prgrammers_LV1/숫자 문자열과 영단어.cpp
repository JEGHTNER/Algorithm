#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <iostream>

using namespace std;

int solution(string s) {
    string answer = "";
	string tmp_str = "";
	map<string, string> dict;
	int	index = 0;

	dict["zero"] = "0";
	dict["one"] = "1";
	dict["two"] = "2";
	dict["three"] = "3";
	dict["four"] = "4";
	dict["five"] = "5";
	dict["six"] = "6";
	dict["seven"] = "7";
	dict["eight"] = "8";
	dict["nine"] = "9";

	while (index < s.size())
	{
		if (isdigit(s[index]))
			answer += s[index];
		else
			tmp_str += s[index];
		if (dict.find(tmp_str) != dict.end())
		{
			answer += dict[tmp_str];
			tmp_str = "";
		}
		index++;
	}
    return stoi(answer);
}

int main()
{
	string s = "123four"; // "23four5six7"	"2three45sixseven"	"123"	

	cout <<solution(s) <<endl;
}