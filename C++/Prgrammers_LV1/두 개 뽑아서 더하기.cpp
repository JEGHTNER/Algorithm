#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;

	for (int i = 0; i < numbers.size() - 1; i++)
	{
		for (int j = i + 1 ; j < numbers.size(); j++)
		{
			answer.push_back(numbers[i] + numbers[j]);
		}
	}
	sort(answer.begin(), answer.end());
	answer.erase(unique(answer.begin(),answer.end()),answer.end());
    return answer;
}

int main()
{
	vector<int> answer;
	vector<int> numbers = {2,1,3,4,1};
	answer = solution(numbers);
	for (int i = 0; i< answer.size(); i++)
	{
		cout << answer[i]<<endl;
	}
}
