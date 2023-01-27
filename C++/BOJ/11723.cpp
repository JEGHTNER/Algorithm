#include <iostream>
#include <vector>
#include <sstream>
#include <string>
using namespace std;

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    int m;
    cin>>m;
    vector<pair<int, int>> lst;
    for (int i = 1; i <= 20; i++)
        lst.push_back(pair(i, 0));
    for (int i = 0; i < m; i++)
    {
        string read;
        int num;
        cin>>read;
        if (read == "all")
        {
            for (int j = 0; j <= 20; j++)
                lst[j].second = 1;
        }
        else if (read == "empty")
        {
            for (int j = 0; j <= 20; j++)
                lst[j].second = 0;
        }
        else if (read == "add")
        {
            cin>>num;
            lst[num].second = 1;
        }
        else if (read == "check")
        {
            cin>>num;
            if (lst[num].second == 0)
                cout << 0 <<"\n";
            else
                cout << 1 << "\n";
        }
        else if (read == "remove")
        {
            cin>>num;
            lst[num].second = 0;
        }
        else if (read == "toggle")
        {
            cin>>num;
            if (lst[num].second == 0)
                lst[num].second = 1;
            else
                lst[num].second = 0;
        }
    }
}