#include <string>
#include <vector>
#include<iostream>
using namespace std;

int solution(int n) {
    int answer = 0;

    for (int i = 1; i < n; i++)
    {
        if (n % i == 1)
            return i;
    }
    return answer;
}

int main()
{
    for(int i = 1; i<1000000;i++)
        cout << solution(i) << endl;
}