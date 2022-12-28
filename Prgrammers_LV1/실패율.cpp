#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include<iostream>
using namespace std;

bool cmp(pair<int, double> &a, pair<int, double> &b)
{
    if (a.second == b.second)
        return a.first < b.first;
    else
        return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int, double>> rate;
    int stage_len = stages.size();

    for (int i = 1; i < N + 1; i++)
    {
        if (stage_len != 0)
        {
            double non_clear = count(stages.begin(),stages.end(),i);
            rate.push_back({i, double(non_clear / stage_len)});
            stage_len -= non_clear;
        }
        else
            rate.push_back({i,0});
    }
    std::sort(rate.begin(), rate.end(),cmp);
    for (int i = 0; i < rate.size(); i++)
    {
        auto p = rate[i];
        answer.push_back(p.first);
    }
    return answer;
}



int main()
{
    vector<int> stages = {2,1,2,6,2,4,3,3};
    int N = 5;
    vector<int> answers = solution(N,stages);
    for (int i = 0 ; i < answers.size(); i++)
        cout << answers[i];
}