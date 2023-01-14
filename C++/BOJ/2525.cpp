#include <iostream>

using namespace std;

int main()
{
	int hour, minute;
	int add_time;
	cin >> hour >> minute;
	cin >> add_time;

	minute += add_time;
	while (minute >= 60)
	{
		if (minute > 59)
		{
			minute -= 60;
			hour += 1;
		}
		if (hour > 23)
			hour -= 24;
	}
	cout << hour<<" " << minute;
}