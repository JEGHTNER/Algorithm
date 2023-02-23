#include<iostream>
#include<cmath>

using namespace std;

int n;
int table[20]{};
int min = 1e9;

int main()
{
    int sum = 0;
    int num;
    cin>>n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin>>num;
            sum += num;
            table[i] += num;
            table[j] += num;
        }
    }
}