#include<iostream>
#include<vector>

using namespace std;

int main()
{
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);

    int n, m;
    int num;
    cin>>n>>m;
    vector<vector<int>> dp(n + 1,vector<int>(n + 1, 0));
    vector<vector<int>> table(n, vector<int>(n));
    for (int i = 0; i < n; i++)
    {
        vector<int> tmp = {};
        for (int j = 0; j < n; j++)
        {
            cin>>num;
            table[i][j] = num;
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + table[i - 1][j - 1];
    }
    for (int i = 0; i < m; i++)
    {
        int x1, y1, x2, y2;
        cin>>x1>>y1>>x2>>y2;
        cout<<dp[x2][y2] - dp[x1 -1][y2] - dp[x2][y1 -1] + dp[x1 - 1][y1 - 1]<<"\n";
    }
}