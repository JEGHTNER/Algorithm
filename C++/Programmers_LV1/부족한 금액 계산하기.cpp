#include<iostream>
using namespace std;

long long solution(int price, int money, int count)
{
    long long answer = 0;
    int tmp = price;
    for (int i = 1; i <= count; i++)
    {
        tmp = i*price;
        answer += tmp;
    }
    if (money - answer < 0)
        return(answer - money);

    return 0;
}

int main()
{
    int price = 3, money = 20, count = 4;
    cout << solution(price, money, count) << endl;
}