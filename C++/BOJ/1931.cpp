#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

bool cmp(pair<int, int> &a, pair<int, int> &b)
{
	if(a.second == b.second) 
		return a.first < b.first;
	return a.second < b.second;
}

int main()
{
    vector<pair<int, int>> lst;
    int start, end;
    int n;
    cin>>n;
    int cnt = 0, e_time = 0;
    for (int i = 0; i < n; i++)
    {
        cin>>start>>end;
        lst.push_back(pair(start, end));
    }
    sort(lst.begin(), lst.end(), cmp);
    for (auto c : lst)
    {
        if (c.first >= e_time)
        {
            cnt++;
            e_time = c.second;
        }
    }
    cout<<cnt<<"\n";
}