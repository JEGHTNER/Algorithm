#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
	vector<int> stack={};
	vector<int> tmp ={};
	vector<int> hamburger={1,3,2,1};

	for(auto i : ingredient)
	{
		stack.push_back(i);
		if (stack.size() >= 4)
		{
			vector<int>:: reverse_iterator riter(stack.rbegin());
			for(int it = 0; it < 4; it++)
			{
				tmp.push_back(*(riter++));
			}
		}
		if (tmp == hamburger)
		{
			answer++;
			for(int it = 0; it < 4; it++)
				stack.pop_back();
		}
		tmp.clear();
	}
    return answer;
}
#include<iostream>
int main()
{
	vector<int> ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
	cout << solution(ingredient);
}