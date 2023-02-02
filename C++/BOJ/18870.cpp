#include<iostream>
#include<map>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);
	int	n;
	cin>>n;
	vector<int> nums;
	map<int, int>	dic;
	for (int i = 0; i < n; i++)
	{
		int num;
		cin>>num;
		nums.push_back(num);
	}
	vector<int> s_num(nums.begin(), nums.end());
	sort(s_num.begin(), s_num.end());
	s_num.erase(unique(s_num.begin(), s_num.end()),s_num.end());
	for (int i = 0; i < s_num.size(); i++)
		dic[s_num[i]] = i;
	for (auto n : nums)
		cout<<dic[n]<<" ";
	cout <<"\n";
}