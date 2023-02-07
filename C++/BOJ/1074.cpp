#include<iostream>
#include<algorithm>
#include<math.h>

using namespace std;

int n, r, c;
int cnt = 0;

void	recur(int n, int y, int x)
{
	if (y == r && x == c)
	{
		cout<<cnt<<"\n";
		exit(0);
	}
	if (n == 1)
	{
		cnt++;
		return ;
	}
	if (!(y <= r && r < y + n && x <= c && c < x + n))
	{
		cnt += n * n;
		return ;
	}
	recur(n/2, y, x);
	recur(n/2, y, x + n/2);
	recur(n/2, y+n/2, x);
	recur(n/2, y + n/2, x + n/2);
}

int main()
{
	cin>>n>>r>>c;
	recur(pow(2,n), 0, 0);
}