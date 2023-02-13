#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main()
{
    int n;
    int num;
    vector<int> nums;
    vector<int> dp;
    cin>>n;
    for (int i = 0; i < n; i++)
    {
        cin>>num;
        nums.push_back(num);
        dp.push_back(0);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (nums[i] > nums[j] && dp[i] < dp[j])
                dp[i] = dp[j];
        }
        dp[i] += 1;
    }
    cout<<*max_element(dp.begin(), dp.end());
}