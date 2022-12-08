#include <string>
#include <vector>
#include <iostream>

using namespace std;

void swap(int *col, int *row)
{
	int tmp = *col;
	*col = *row;
	*row = tmp;
}

int solution(vector<vector<int>> sizes) {
    int answer = 0;
	int	max_l = 0;
	int max_r = 0;

	for (int i = 0; i < sizes.size();i++)
	{
		if (sizes[i][0] < sizes[i][1])
			swap(sizes[i][0], sizes[i][1]);
		if (sizes[i][0] > max_l)
			max_l = sizes[i][0];
		if (sizes[i][1] > max_r)
			max_r = sizes[i][1];
	}
	answer = max_r * max_l;
    return answer;
}

int main()
{
	vector<vector<int>> sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
	cout<< solution(sizes) << endl;
}
