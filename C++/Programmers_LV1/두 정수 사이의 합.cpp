#include <string>
#include <vector>
#include<iostream>
using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    for (int i = min(a, b); i <= max(a, b); i++)
    {
        answer += i;
    }
    return answer;
}

int main()
{
    cout << solution(5, 5);
}