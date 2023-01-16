#include <string>
#include <vector>
#include<algorithm>
#include<iostream>

using namespace std;

int solution(string s) {
    int answer = 0;

    answer = stoi(s);
    return answer;
}

int main()
{
    cout << solution("-1234") << " " << solution("1234") << endl;
}