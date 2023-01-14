#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;



string solution(vector<int> food) {
    string answer = "";
    string half = "";
    
    for (int i = 1; i < food.size(); i++)
    {
        food[i] = food[i] / 2;
        for(int j = 0; j < food[i]; j++)
            half += to_string(i);
    }
    answer = half + '0';
    reverse(half.begin(), half.end());
    answer += half;
    return answer;
}

int main()
{
    cout << solution({1,3,4,6});
}