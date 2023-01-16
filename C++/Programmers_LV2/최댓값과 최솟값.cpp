#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
using namespace std;

vector<int> split(string input , char delimiter)
{
    vector<int> answer;
    stringstream ss(input);
    string tmp;

    while(getline(ss, tmp, delimiter))
        answer.push_back(stoi(tmp));
    return answer;
}

string solution(string s) {
    string answer = "";
    vector<int> lst;
    lst = split(s,' ');

    answer += to_string(*min_element(lst.begin(), lst.end()));
    answer += " ";
    answer += to_string(*max_element(lst.begin(), lst.end()));
    return answer;
}

#include<iostream>

int main()
{
    string s = "-1 -2 -3 -4";
    cout <<solution(s);
}