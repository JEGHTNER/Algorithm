#include<iostream>

using namespace std;

int main()
{
    // cin.tie(0);
    // ios::sync_with_stdio(0);
    int dp[1001] = {0,};
    int n;
    
    dp[1] = 1;
    dp[2] = 2;
    cin>>n;
    for (int i = 3; i <= n; i++)
        dp[i] = dp[i - 2] %10007 + dp[i - 1] % 10007;
    cout<<dp[n] % 10007;
}