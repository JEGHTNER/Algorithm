#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<string> compareMaps(int n, vector<string> arr1, vector<string> arr2)
{
	vector<string> final_map;

	for (int i = 0; i < n; i++)
	{
		string	str = "";
		for (int j = 0; j < arr1[i].size();j++)
		{
			if( (arr1[i][j] - 48) + (arr2[i][j] - 48) > 0)
				str += "#";
			else
				str += " ";
		}
		final_map.push_back(str);
	}
	return final_map;
}

string toBinary(int n, int num)
{
	string str = "";
	while (num > 0)
	{
		str += to_string(num % 2);
		num /= 2;
	}
	while (str.size() < n)
		str += '0';
	reverse(str.begin(),str.end());
	return (str);
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
	vector<string> map1;
	vector<string> map2;
	for (int i = 0; i < n; i++)
	{
		map1.push_back(toBinary(n, arr1[i]));
		map2.push_back(toBinary(n, arr2[i]));
	}
	answer = compareMaps(n, map1, map2);
    return answer;
}

int main()
{
	int n = 5;
	vector<int> arr1;
	arr1.push_back(9);
	arr1.push_back(20);
	arr1.push_back(28);
	arr1.push_back(18);
	arr1.push_back(11);
	vector<int> arr2;
	arr2.push_back(30);
	arr2.push_back(1);
	arr2.push_back(21);
	arr2.push_back(17);
	arr2.push_back(28);
	for (int i = 0; i < n; i++){
		cout << solution(n,arr1,arr2)[i]<<endl;
	}
}