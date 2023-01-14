#include <string>
#include <vector>
#include <iostream>
#include <regex>
#include <cstring>
using namespace std;

string solution(string new_id) {
    string answer = "";
	//#1 to_lower
	for (int i = 0; i < new_id.size(); i++)
		new_id[i] = tolower(new_id[i]);
	//#2 del !@#*
	int i  = 0;
	while (new_id[i])
	{
		if (!isalnum(new_id[i]) && strchr("-_.", new_id[i]) == NULL)
		{
			new_id.erase(new_id.begin() + i);
			i = -1;
		}
		i++;
	}
    //#3 ..->.
	answer = regex_replace( new_id, regex("[.]+"), "." );
    //#4 del first. last.
	if (answer[0] == '.')
		answer.erase(answer.begin());
	if (answer.back() == '.')
		answer.pop_back();
    //#5 empty -> +"a"
	if (answer.size() == 0)
		answer += "a";
    //#6 len >15 -> cut ~16, del last.
	if (answer.size() > 15)
		answer = answer.substr(0,15);
	if (answer.back() == '.')
		answer.pop_back();
    //#7 len <3 -> new_id + new_id[-1] until 3
	while(answer.size() < 3)
		answer += answer.back();
    return answer;
}

int main()
{
	string new_id = "...!@BaT#*..y.abcdefghijklm";
	cout << solution(new_id);
}
