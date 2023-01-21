#include<iostream>
#include<vector>
#include<string>
#include<algorithm>

using namespace std;

vector<int>    quicksort(vector<int> lst)
{
    if (lst.size() <= 1)
        return lst;
    int pivot = lst[lst.size() / 2];
    vector<int> left, mid, right;
    for (auto num : lst)
    {
        if (num > pivot)
            left.push_back(num);
        else if (num < pivot)
            right.push_back(num);
        else
            mid.push_back(num);
    }
    vector<int> ret = quicksort(left);
    ret.insert(ret.end(), mid.begin(),mid.end());
    right = quicksort(right);
    ret.insert(ret.end(),right.begin(),right.end());
    return ret;
}

int main()
{
    vector<int> lst ={};
    int n;
    cin>>n;
    string s_n = to_string(n);
    for(auto c: s_n)
        lst.push_back(c - '0');
    lst = quicksort(lst);
    for(auto i : lst)
        cout <<i;
}