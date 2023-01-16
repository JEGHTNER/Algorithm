#include <string>
#include <vector>
#include<algorithm>
#include<iostream>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<char> list;
    string num = to_string(n);
    for (int i = 0; i < num.length(); i++)
        list.push_back(num[i]);
    sort(list.begin(), list.end());
    reverse(list.begin(), list.end());
    string str(list.begin(), list.end());
    answer = stoll(str);
    return answer;
}

int main()
{
    cout<< solution(11287572472);
}