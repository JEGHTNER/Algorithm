#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    vector<int> honor;
    
    for (int i = 0; i < score.size(); i++)
    {
        if (honor.size() >= k)
        {
            int min_val = *min_element(honor.begin(), honor.end());
            if (score[i] > min_val)
            {
                int index = find(honor.begin(), honor.end(), min_val)- honor.begin();
                honor.push_back(score[i]);
                honor.erase(honor.begin() + index);
            }
        }
        else
            honor.push_back(score[i]);
        answer.push_back(*min_element(honor.begin(), honor.end()));
    }
    return answer;
}

#include<iostream>
#include"printDictionary.cpp"

int main()
{
    vector<int> score = {10, 100, 20, 150, 1, 100, 200};
    vector<int> answer = solution(3, score);
    printDictionary(answer);
}