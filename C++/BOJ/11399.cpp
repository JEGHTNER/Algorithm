#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<int> P;
    vector<int> dp;
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        int p;
        cin>>p;
        P.push_back(p);
        dp.push_back(0);
    }
    sort(P.begin(), P.end());
    for (int i = 0; i < P.size(); i++)
    {
        if (i == 0)
            dp[i] = P[i];
        else
            dp[i] += dp[i - 1] + P[i];
        sum += dp[i];
    }
    cout<<sum;
}