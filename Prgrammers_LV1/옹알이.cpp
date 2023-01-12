#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

int check_babble(string babble)
{
	vector<string> words = {"aya", "ye", "woo", "ma"};
	string tmp = "";
	string last_word = "";
	for (auto ch : babble)
	{
		tmp += ch;
		if (tmp == last_word)
			return 0;
		if (find(words.begin(), words.end(),tmp) != words.end())
		{
			last_word = tmp;
			tmp = "";
		}
	}
	if (tmp == "")
		return 1;
	return 0;
}

int solution(vector<string> babbling) {
    int answer = 0;
	for (auto babble : babbling)
		answer += check_babble(babble);
    return answer;
}

int main()
{
	vector<string> babbling = {"aya", "yee", "u", "maa"};
	cout << solution(babbling);
}