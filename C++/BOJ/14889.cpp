#include<iostream>
#include<cmath>

using namespace std;

int n;
int table[20]{};
int min_dif = 1e9;

void dfs(int idx, int start, int sum)
{
    if (idx == n / 2)
    {
        if (min_dif > std::abs(sum))
            min_dif = std::abs(sum);
    }
    if (start < n - 1)
    {
        dfs(idx + 1, start + 1, sum - table[start]);
        dfs(idx, start + 1, sum);
    }
}

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
    dfs(0, 0, sum);
    cout << min_dif;
}