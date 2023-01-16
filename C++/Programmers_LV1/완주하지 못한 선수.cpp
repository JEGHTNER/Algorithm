#include <string>
#include <vector>
#include <functional>
#include <map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<size_t, string> dic;
    ssize_t temp;
    hash<string> str_hash;

    temp = 0;
    for (int i = 0; i < participant.size(); i++)
    {
        dic[str_hash(participant[i])] = participant[i];
        temp += str_hash(participant[i]);
    }
    for (int i = 0; i < completion.size(); i++)
    {
        temp-=str_hash(completion[i]);
    }

    return dic[temp];
}

#include <iostream>
int main()
{
    cout << solution({"leo", "kiki", "eden"}, {"eden", "kiki"});
}
