#include<iostream>
#include<vector>

using namespace std;

int n, m;
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
    for (int i = 1; i <= n; i++)
    {
        lst.push_back(i);
        dfs();
        lst.pop_back();
    }
}

int main()
{
    cin>>n>>m;
    dfs();
}