#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

vector<int> lst;

void	dfs(int n, int m)
{
	if (lst.size() == m)
	{
		for (auto l : lst)
			cout<<l<<" ";
		cout<<"\n";
		return ;
	}
	for (int i = 1; i <= n; i++)
	{
		if (find(lst.begin(), lst.end(), i) == lst.end())
			lst.push_back(i);
			dfs(n, m);
			lst.pop_back();
	}

}

int main()
{
	int n, m;
	cin>>n>>m;

	dfs(n, m);
}