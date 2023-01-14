#include <string>
#include <vector>
#include <iostream>
#include<algorithm>

using namespace std;

int get_num(vector<int> array, vector<int> command)
{
	//2,5,3
	vector<int> lst;
	lst.assign(array.begin() + (command[0] - 1), array.begin() + (command[1]));

	sort(lst.begin(), lst.end());
	return (lst[command[2] - 1]);
}

vector<int> solution(vector<int> array, vector < vector < int > > commands) {
    vector<int> answer;

	for (int i = 0; i < commands.size(); i++)
	{
		answer.push_back(get_num(array, commands[i]));
	}
    return answer;
}

int main()
{
	vector<int> array;
	vector < vector < int> > commands;
	vector<int> answer;
	array.push_back(1);
	array.push_back(5);
	array.push_back(2);
	array.push_back(6);
	array.push_back(3);
	array.push_back(7);
	array.push_back(4);

	commands.push_back({2,5,3});
	commands.push_back({4,4,1});
	commands.push_back({1,7,3});
	answer = solution(array, commands);
	cout<<answer.size();
	for (int i; i < answer.size(); i++)
	{
		cout << array[i] <<endl;
	}
	
}