#include<iostream>
#include<map>

using namespace std;

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int n, m;
    cin>> n >> m;

    map<int, string> dic_num;
    map<string, int> dic_name;
    for (int i = 1 ; i < n + 1; i++)
    {
        string s;
        cin >> s;
        dic_num[i] = s;
        dic_name[s] = i;
    }
    for (int j = 0; j < m; j++)
    {
        string ans;
        cin>>ans;
        if (isdigit(ans[0]))
            cout<<dic_num[stol(ans)]<<"\n";
        else
            cout<<dic_name[ans]<<"\n";
    }
}