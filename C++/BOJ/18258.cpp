#include<iostream>
#include<deque>

using namespace std;

int n;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>n;
    deque<int> dq;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin>>s;
        if (s == "push")
        {
            int num;
            cin>>num;
            dq.push_back(num);
        }
        else if (s == "pop")
        {
            if (dq.empty())
                cout<<"-1"<<"\n";
            else
            {
                cout<<dq.front()<<"\n";
                dq.pop_front();
            }
        }
        else if (s == "size")
            cout<<dq.size()<<"\n";
        else if (s == "empty")
            cout<<dq.empty()<<"\n";
        else if (s == "front")
        {
            if (dq.empty())
                cout<<"-1"<<"\n";
            else
                cout<<dq.front()<<"\n";
        }
        else if (s == "back")
        {
            if (dq.empty())
                cout<<"-1"<<"\n";
            else
                cout<<dq.back()<<"\n";
        }
    }
}