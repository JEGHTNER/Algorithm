#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> quicksort(vector<int> lst)
{
    if (lst.size() <= 1)
        return lst;
    int pivot = lst[lst.size() / 2];
    vector<int> left, mid, right;

    for (auto num : lst)
    {
        if (num < pivot)
            left.push_back(num);
        else if (num > pivot)
            right.push_back(num);
        else
            mid.push_back(num);
    }
    vector<int> ret = quicksort(left);
    ret.insert(ret.end(), mid.begin(), mid.end());
    right = quicksort(right);
    ret.insert(ret.end(),right.begin(), right.end());
    return ret;
}

vector<int> quicksort_reverse(vector<int> lst)
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
    vector<int> ret = quicksort_reverse(left);
    ret.insert(ret.end(), mid.begin(), mid.end());
    right = quicksort_reverse(right);
    ret.insert(ret.end(),right.begin(), right.end());
    return ret;
}

int main()
{
    int n;
    cin>>n;
    vector<int> a, b;
    for (int i = 0; i < n; i++)
    {
        int num;
        cin>>num;
        a.push_back(num);
    }
    for (int i = 0; i < n; i++)
    {
        int num;
        cin>>num;
        b.push_back(num);
    }
    
    a = quicksort(a);
    b = quicksort_reverse(b);
    int sum = 0;
    for (int i = 0; i < n; i++)
        sum += a[i] * b[i];
    cout<<sum;
}