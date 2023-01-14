#include <string>
#include <vector>
#include <math.h>
#include <iostream>
#include <algorithm>

using namespace std;

int ternary(int n)
{
	vector<int> lst;
	int	ans = 0;
	while (n > 0)
	{
		lst.push_back(n % 3);
		n /= 3;
	}
	reverse(lst.begin(),lst.end());
	for (int i = 0; i< lst.size(); i++)
		ans += pow(3,i) * lst[i];

	return ans;
}

int solution(int n) {
    int answer = 0;

	answer = ternary(n);
    return answer;
}

int main()
{
	int n = 45;
	cout << solution(n)<<endl;
}