#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    int empty_bottle = n;
    while (empty_bottle >= a)
    {
        answer += empty_bottle / a * b;
        empty_bottle = empty_bottle - a * (empty_bottle / a) + (empty_bottle / a * b);
    }
    return answer;
}

#include<iostream>

int main()
{
    cout << solution(2, 1, 20);
}