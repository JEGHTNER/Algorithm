#include <string>
#include <vector>
#include<iostream>
using namespace std;

int	check_rank(int num)
{
	if (num == 6)
		return 1;
	else if (num == 5)
		return 2;
	else if (num == 4)
		return 3;
	else if (num == 3)
		return 4;
	else if (num == 2)
		return 5;
	else
		return 6;
}

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
	int	max_count = 0;
	int min_conut = 0;

	for (int i = 0; i < lottos.size(); i++)
	{
		if (find(win_nums.begin(), win_nums.end(), lottos[i]) != win_nums.end())
		{
			max_count++;
			min_conut++;
		}
		if (lottos[i] == 0)
			max_count++;
	}
	answer.push_back(check_rank(max_count));
	answer.push_back(check_rank(min_conut));
    return answer;
}

int main()
{
	vector<int> answer = solution({44, 1, 0, 0, 31, 25}, {31, 10, 45, 1, 6, 19});

	for (int i = 0; i< answer.size(); i++)
	{
		cout << answer[i]<<" ";
	}
}