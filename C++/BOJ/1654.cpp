#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

long long N, K;

long long binary_Search(vector<long long> lst, long long start, long long end)
{
    long long result;
    while (start <= end)
    {
        long long sum = 0;
        long long mid = (start + end) / 2;
        for (auto num : lst)
            sum += num / mid;
        
        if (sum < K)
            end = mid - 1;
        else
        {
            result = mid;
            start = mid + 1;
        }
    }
    return (result);
}

int main()
{
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);
    cin>> N >> K; 
    vector<long long> lst;
    for (int i = 0; i < N; i++)
    {
        long long num;
        cin>>num;
        lst.push_back(num);
    }
    cout<< (binary_Search(lst, 1, *max_element(lst.begin(), lst.end())));
}
