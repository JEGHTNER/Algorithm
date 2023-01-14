#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
	vector<int> new_lost;
	vector<int> new_reserve;

	new_lost.assign(lost.begin(), lost.end());
	new_reserve.assign(reserve.begin(), reserve.end());

	for (int i = 0; i < reserve.size(); i++)
	{
		if (find(lost.begin(), lost.end(), reserve[i]) != lost.end())
		{
			new_lost.erase(remove(new_lost.begin(), new_lost.end(), reserve[i]), new_lost.end());
			new_reserve.erase(remove(new_reserve.begin(), new_reserve.end(), reserve[i]), new_reserve.end());
		}
	}
	sort(new_lost.begin(), new_lost.end());
	sort(new_reserve.begin(),new_reserve.end());
	for (int i = 0; i < new_reserve.size(); i++)
	{
		if (find(new_lost.begin(), new_lost.end(), new_reserve[i] - 1) != new_lost.end())
			new_lost.erase(remove(new_lost.begin(), new_lost.end(), new_reserve[i] - 1), new_lost.end());
		else if (find(new_lost.begin(), new_lost.end(), new_reserve[i] + 1) != new_lost.end())
			new_lost.erase(remove(new_lost.begin(), new_lost.end(), new_reserve[i] + 1), new_lost.end());
	}
	answer = n - new_lost.size();
    return answer;
}

int main()
{
	vector<int> a;
	a.push_back(4);
	a.push_back(6);
	a.push_back(7);
	vector<int> b;
	b.push_back(5);
	b.push_back(6);
	b.push_back(8);
	cout << solution(10,a, b);
}