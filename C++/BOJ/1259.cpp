#include<iostream>

using namespace std;

int main()
{
	while (true)
	{
		bool	flag = true;
		string num;
		cin>>num;
		if (num == "0")
			break;
		else
		{
			int len = num.size();
			for (int i = 0; i < len; i++)
			{
				if (num[i] != num[len -1 -i])
					flag = false;
			}
		}
		if (flag == false)
			cout<<"no\n";
		else
			cout<<"yes\n";
	}
}