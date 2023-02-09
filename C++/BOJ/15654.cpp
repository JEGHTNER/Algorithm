#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int n, m;
vector<int> nums;
vector<int> lst;

void    dfs()
{
    if (lst.size() == m)
    {
        for (auto l : lst)
            cout<<l<<" ";
        cout<<"\n";
        return ;
    }
    for (auto num : nums)
    {
        if (find(lst.begin(), lst.end(), num) == lst.end())
        {
            lst.push_back(num);
            dfs();
            lst.pop_back();
        }   
    }
}

int main()
{
    
    int num;
    
    cin>>n>>m;

    for (int i = 0; i < n; i++)
    {
        cin>>num;
        nums.push_back(num);
    }
    sort(nums.begin(), nums.end());
    dfs();
}
