#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <numeric>

using namespace std;

vector<vector<int> > combinations(vector<int> number, int n)
{
	vector<vector<int> > combs;
	
	for (int i = 0; i <= number.size() - n; i++)
	{
		cout << "i="<<i<<endl;
		for (int j = i + 1; j < number.size() - 1; j++)
		{
			cout <<"j="<< j<<endl;
			for (int k = j + 1; k < number.size(); k++ )
			{
				cout <<"k="<< k<<endl;
				vector<int>	tmp = {};
				tmp.push_back(number[i]);
				tmp.push_back(number[j]);
				tmp.push_back(number[k]);
				combs.push_back(tmp);
				cout << "tmp = "<<tmp[0]<<tmp[1]<<tmp[2]<< endl;
			}
		}
	}
	return (combs);
}

int solution(vector<int> number) {
    int answer = 0;
	int	sum = 0;
	vector<vector<int> > combs = combinations(number, 3);
	for (int i = 0; i < combs.size(); i++)
	{
		if ((sum = accumulate(combs[i].begin(), combs[i].end(),0)) == 0)
			answer +=1;
	}
    return answer;
}
int main()
{
	vector<int> number;
	vector<vector<int> > ans;

	number.push_back(-2);
	number.push_back(3);
	number.push_back(0);
	number.push_back(2);
	number.push_back(-5);
	cout <<solution(number)<<endl;
}