#include<iostream>
#include<deque>

using namespace std;



int main()
{
	int	visited[100001] = {0, };
	int n, k;
	cin>>n>>k;
	deque<int> que;
	que.push_back(n);
	while (que.size())
	{
		int x = que.front();
		que.pop_front();
		if (x == k)
		{
			cout<<visited[x];
			break;
		}
		if (x - 1 >= 0 && visited[x - 1] == 0)
		{
				visited[x - 1] = visited[x] + 1;
				que.push_back(x - 1);
		}
		if (x + 1 <= 100000 && visited[x + 1] == 0)
		{
				visited[x + 1] = visited[x] + 1;
				que.push_back(x + 1);
		}
		if (x * 2 <= 100000 && visited[x * 2] == 0)
		{
			visited[x * 2] = visited[x] + 1;
			que.push_back(x * 2);
		}
	}
}
