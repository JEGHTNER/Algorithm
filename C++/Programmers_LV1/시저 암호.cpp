#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s, int n) {
    string answer = "";
	string alphabet = "abcdefghijklmnopqrstuvwxyz";
	string ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for (int i = 0; i< s.size(); i ++)
	{
		int index = 0;
		if (alphabet.find(s[i]) != string::npos)
		{
			index = (alphabet.find(s[i]) + n) % 26;
			answer += alphabet[index];
		}
		else if (ALPHABET.find(s[i]) != string::npos)
		{
			index = (ALPHABET.find(s[i]) + n) % 26;
			answer += ALPHABET[index];
		}
		else
			answer += ' ';
	}
    return answer;
}

int main()
{
	string s ="AB";
	int n = 1;
	cout << solution(s, n) <<endl;
}