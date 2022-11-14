#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

string solution(string s) {
    string answer = s;
    sort(answer.begin(), answer.end());
    reverse(answer.begin(), answer.end());
    return answer;
}

int main()
{
    string s = "Zbcdefg";
    cout << solution(s) << endl;
}