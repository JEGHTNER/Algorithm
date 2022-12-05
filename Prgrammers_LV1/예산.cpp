#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;
	sort(d.begin(), d.end());
	while (answer < d.size() && budget >= 0)
	{
		budget -= d[answer];
		if (budget < 0)
			break;
		answer++;
	}
    return answer;
}

int main()
{
	vector<int> d = {1,3,2,5,4};
	int	budget = 9;
	cout << solution(d, budget) << endl;
}