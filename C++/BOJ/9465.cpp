#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
	int	t;
	cin>>t;
	for (int i = 0; i < t; i++)
	{
		vector<vector<int>> lst = {};
		vector<int> line = {};
		int n;
		int tmp;
		cin>>n;
		for (int j = 0; j < 2; j++)
		{
			line = {};
			for (int k = 0; k < n; k++)
			{	
				cin>>tmp;
				line.push_back(tmp);
			}
			lst.push_back(line);
		}
		for (int idx = 1; idx < n; idx++)
		{
			if (idx == 1)
			{
				lst[0][idx] += lst[1][idx - 1];
				lst[1][idx] += lst[0][idx - 1];
			}
			else
			{
				lst[0][idx] += max(lst[1][idx - 1], lst[1][idx - 2]);
				lst[1][idx] += max(lst[0][idx - 1], lst[0][idx - 2]);
			}
		}
		cout<<max(lst[0][n - 1], lst[1][n - 1])<<"\n";
	}
}