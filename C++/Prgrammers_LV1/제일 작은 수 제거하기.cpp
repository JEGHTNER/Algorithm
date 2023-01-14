#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer = arr;
    int min_index = min_element(answer.begin(), answer.end()) - answer.begin();
    answer.erase(answer.begin()+ min_index);

    if (answer.size() == 0)
        answer.push_back(-1);
    return answer;
}

int main()
{
    vector<int> answer = { 10 };
    answer = solution(answer);
    for (int i = 0; i < answer.size(); i++)
    {
        cout << answer[i] << endl;
    }
}