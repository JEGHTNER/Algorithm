#include <iostream>
#include <vector>

using namespace std;

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    vector<pair<int, int>> dp ={{},};

    dp[0] = {1,0};
    dp[1] = {0,1};
    for (int i = 2; i <= 40; i++)
        dp[i] = {dp[i - 1].first + dp[i -2].first, dp[i - 1].second + dp[i - 2].second};
    int t;
    cin>>t;
    for (int i = 0; i < t; i++)
    {
        int num;
        cin>>num;
        cout<<dp[num].first<<" "<<dp[num].second<<"\n";
    }
}