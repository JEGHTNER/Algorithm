#include<iostream>
#include<stack>
#include<vector>

using namespace std;

int main()
{
    stack<int> s;
    vector<char> answer;
    int cur = 1;
    int n;
    cin>>n;

    for (int i = 0; i < n; i++)
    {
        int num;
        cin>>num;

        while (cur <= num)
        {
            s.push(cur);
            cur+=1;
            answer.push_back('+');
        }
        if (s.top() == num)
        {
            s.pop();
            answer.push_back('-');
        }
        else
        {
            cout << "NO";
            return 0;
        }
    }
    for (int i = 0; i < answer.size(); i++)
        cout << answer[i] <<'\n';   
}