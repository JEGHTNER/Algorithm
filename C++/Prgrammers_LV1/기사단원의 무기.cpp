#include <string>
#include <vector>
#include <cmath>
#include <set>
#include <algorithm>
#include <iostream>
using namespace std;


int	get_divisor(int num, int limit, int power)
{
	vector<int> lst = {};
	set<int>	s;
	int			ret = 0;
	for (int i = 1; i < int(pow(num, 0.5)) + 1; i++)
	{
		if(num % i == 0)
		{
			lst.push_back(num / i);
			lst.push_back(i);
			s.insert(num/i);
			s.insert(i);
		}
	}
	// for (auto p : s)
    // 	std::cout <<p << endl;
	ret = s.size();
	if (ret > limit)
		return (power);
	return ret;
}

int solution(int number, int limit, int power) {
    int answer = 0;
	vector<int> vec ={};

	for (int i = 1; i <= number; i++)
		vec.push_back(i);
	for (auto num : vec)
		answer += get_divisor(num, limit, power);
    return answer;
}

#include<iostream>
int main()
{
	cout <<solution(5,3,2)<<endl;
}