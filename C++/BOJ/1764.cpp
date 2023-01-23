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
    vector<string> see;

    for (int i = 0; i < n; i++)
    {
        string tmp;
        cin>>tmp;
        hear.push_back(tmp);
    }
    for (int j = 0; j < m; j++)
    {
        string tmp;
        cin>> tmp;
        see.push_back(tmp);
    }
    vector<string>::iterator iter;
    vector<string> ans;
    iter = set_intersection(hear.begin(),hear.end(),see.begin(),see.end(),ans.begin());
    for (auto c : ans)
        cout <<c<<"\n";
}