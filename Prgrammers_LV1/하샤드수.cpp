#include <string>
#include <vector>
#include<iostream>
using namespace std;

bool solution(int x) {
    bool answer = true;
    string num;
    int sum = 0;
    //гу
    num = to_string(x);
    for (int i = 0; i < num.length(); i++)
        sum += num[i] - '0';
    if (x % sum == 0)
        answer = true;
    else
        answer = false;
    return answer;
}

int main()
{
    cout << solution(11) << endl << solution(12) << endl;
}