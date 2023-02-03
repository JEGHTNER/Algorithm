#include<iostream>

using namespace std;

int main()
{
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);
	int a,b,c;
	while (1)
	{
		cin>>a>>b>>c;
		if (a == 0 && b == 0 && c == 0)
			return 0;
		int m = max(c, max(a, b));
		if (a == m)
		{
			if (a * a == b * b + c * c)
				cout<<"right\n";
			else
				cout<<"wrong\n";
		}
		else if (b == m)
		{
			if (b * b == a * a + c * c)
				cout<<"right\n";
			else
				cout<<"wrong\n";
		}
		else if (c == m)
		{
			if (c * c == a * a + b * b)
				cout <<"right\n";
			else
				cout <<"wrong\n";
		}
	}
}
