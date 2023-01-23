#include<iostream>
#include<vector>
#include<set>
#include<algorithm>

using namespace std;

int main()
{
    int n, m;
    cin>>n>>m;
    vector<string> hear;
    vector<string> ans;

    for (int i = 0; i < n; i++)
    {
        string tmp;
        cin>>tmp;
        hear.push_back(tmp);
    }
    sort(hear.begin(),hear.end());
    for (int j = 0; j < m; j++)
    {
        string tmp;
        cin>> tmp;
        if (binary_search(hear.begin(), hear.end(),tmp))
            ans.push_back(tmp);
    }
    cout<<ans.size()<<"\n";
    sort(ans.begin(), ans.end());
    for (auto c : ans)
        cout <<c<<"\n";
}