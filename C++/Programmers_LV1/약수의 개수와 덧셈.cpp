#include <string>
#include <vector>
#include<iostream>
using namespace std;

int countDivisor(int num)
{
    int count = 0;
    int i = 1;
    while (i <= num) {
        if (num % i == 0)
            count++;
        i++;
    }
    return(count);
}
int solution(int left, int right) {
    int answer = 0;
    for (int i = left; i <= right; i++)
    {
        if (countDivisor(i) % 2 == 0)
            answer += i;
        else
            answer -= i;
    }
    return answer;
}

int main()
{
    int left = 13, right = 17;
    cout << solution(left, right) << endl;
}