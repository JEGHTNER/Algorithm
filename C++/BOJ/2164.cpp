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
        queue.push_back(i);
    while (queue.size())
    {
        if (queue.size() <= 1)
            break;
        queue.pop_front();
        int tmp = queue.front();
        queue.pop_front();
        queue.push_back(tmp);
    }
    cout<<queue.front();
}