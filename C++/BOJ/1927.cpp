#include<iostream>
#include<queue>
#include<algorithm>

using namespace std;

int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);
	
	priority_queue<pair<int, int>> pq;
	int	n;
	cin>>n;
	for (int i = 0; i < n; i++)
	{
		int x;
		cin>>x;
		if (x == 0)
		{
			if (pq.size())
			{
				cout<<pq.top().second<<"\n";
				pq.pop();
			}
			else
				cout<<0<<"\n";
		}
		else
			pq.push(pair(x * -1, x));
	}
}