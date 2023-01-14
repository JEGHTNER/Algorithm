#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include "printDictionary.cpp"
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char, int> dic;
    char MBTI[4][2] = {
        {'R', 'T'},
        {'C', 'F'},
        {'J', 'M'},
        {'A', 'N'}
    };

    int i = 0;
    for (auto s : survey)
    {
        if (choices[i] < 4)
            dic[s[0]] += 4 - choices[i];
        else
            dic[s[1]] += choices[i] - 4;
        i++;
    }
    for (int i = 0; i < 4; i++)
    {
        if (dic[MBTI[i][0]] < dic[MBTI[i][1]])
            answer += MBTI[i][1];
        else
            answer += MBTI[i][0];
    }
    return(answer);
}

#include <iostream>
int main()
{
    vector<string> survey = {"AN", "CF", "MJ", "RT", "NA"};
    vector<int> choices = {5, 3, 2, 7, 5} ;

    cout << solution(survey, choices);
}