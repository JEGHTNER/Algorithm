#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer = {0, 0, 0};
    vector<int> supo1 = {1, 2, 3, 4, 5};
    vector<int> supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    vector<int> ret = {};
    for (int i = 0 ; i < answers.size(); i++)
    {
        if (answers[i] == supo1[i % 5])
            answer[0]++;
        if (answers[i] == supo2[i % 8])
            answer[1]++;
        if (answers[i] == supo3[i % 10])
            answer[2]++;
    }
    int m = *max_element(answer.begin(), answer.end());
    for (int j = 0 ; j < answer.size(); j++)
    {
        if (answer[j] >= m)
            ret.push_back(j+1);
    }
    return ret;
}
int main()
{
    vector<int> answers = {1,3,2,4,2};
    for (int i = 0 ; i<solution(answers).size();i++)
    {
        cout << answers[i];
    }
    cout <<endl;
}
