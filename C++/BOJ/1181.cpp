#include<iostream>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

bool cmp(std::pair<string,int> &a, std::pair<string,int> &b)
{
	if(a.second == b.second) 
		return a.first < b.first;
	return a.second < b.second;
}

int main()
{
    int n;
    cin>>n;
    map<string,int> dic;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin>>s;
        dic[s] = s.size();
    }
    vector<pair<string,int>> ans(dic.begin(), dic.end());
    sort(ans.begin(),ans.end(),cmp);
    for (auto a : ans)
        cout << a.first<<"\n";
}