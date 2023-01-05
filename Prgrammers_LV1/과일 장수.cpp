#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
	vector<int> temp = {};
	sort(score.begin(), score.end());
	reverse(score.begin(), score.end());
	for (int i = 0; i < score.size(); i++)
	{
		temp.push_back(score[i]);
		if (temp.size() == m)
		{
			answer += *min_element(temp.begin(), temp.end()) * m;
			temp.clear();
		}
	}
    return answer;
}
#include <iostream>

int main()
{
	int k = 4;
	int m = 3;
	vector<int> score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
	cout << solution(k, m, score);
}