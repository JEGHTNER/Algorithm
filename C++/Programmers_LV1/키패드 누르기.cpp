#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> get_pos(vector<vector<int>> phone, int num)
{
	for (int i = 0; i < phone.size(); i++)
	{
		for (int j = 0; j < phone[i].size(); j++)
		{
			if (phone[i][j] == num)
				return {i,j};
		}
	}
	return {0,0};
}

int	get_distance(vector<int> pos, vector<int> next_pos)
{
	return abs(pos[0] - next_pos[0]) + abs(pos[1] - next_pos[1]);
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
	vector<vector<int> > phone = {
		{1,2,3},
		{4,5,6},
		{7,8,9},
		{'*',0,'#'}
	};
	vector<int>	l_pos = {3,0};
	vector<int> r_pos = {3,2};
	vector<int> l_num = {1, 4, 7};
	vector<int> r_num = {3,6,9};

	for (int i = 0; i < numbers.size(); i ++)
	{
		if (find(l_num.begin(), l_num.end(), numbers[i]) != l_num.end())
		{
			answer += 'L';
			l_pos = get_pos(phone, numbers[i]);
		}
		else if (find(r_num.begin(), r_num.end(), numbers[i]) != r_num.end())
		{
			answer += 'R';
			r_pos = get_pos(phone, numbers[i]);
		}
		else
		{
			vector<int> num_pos = get_pos(phone, numbers[i]);
			int l_distance = get_distance(l_pos, num_pos);
			int r_distance = get_distance(r_pos, num_pos);

			if (l_distance > r_distance)
			{
				answer += 'R';
				r_pos = num_pos;
			}
			else if (l_distance < r_distance)
			{
				answer += 'L';
				l_pos = num_pos;
			}
			else
			{
				if (hand == "left")
				{
					answer += 'L';
					l_pos = num_pos;
				}
				else
				{
					answer += 'R';
					r_pos = num_pos;
				}
			}
		}
	}
    return answer;
}

#include "printDictionary.cpp"
#include <iostream>
int main()
{
	cout << solution({7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
}