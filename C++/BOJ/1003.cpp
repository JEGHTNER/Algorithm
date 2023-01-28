#include <iostream>
#include <vector>

using namespace std;

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int dp[41];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= 40; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
    int t;
    cin>>t;
    for (int i = 0; i < t; i++)
    {
        int num;
        cin>>num;
        if (num == 0)
            cout <<"1 0\n";
        else if (num == 1)
            cout <<"0 1\n";
        else
            cout<<dp[num - 1]<<" "<<dp[num]<<"\n";
    }
}