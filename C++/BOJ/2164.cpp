#include<iostream>
#include<vector>
#include<deque>

using namespace std;

int main()
{
    int n;
    cin>>n;

    deque<int> queue;
    for (int i = 1; i <= n; i++)
    {
        queue.push_back(i);
    }

}