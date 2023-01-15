#include<vector>
#include<iostream>
#include<string>
using namespace std;

int main()
{
    int N;
    string  parenthesis = "";
    cin>> N;
    for (int i = 0; i < N; i++)
    {
        vector<char> stack;
        cin>>parenthesis;
        for (auto p : parenthesis)
        {
            stack.push_back(p);
            vector<char>::reverse_iterator r_it = stack.rbegin();
            if (stack.size() > 1)
            {
                if (*r_it == ')' && *(++r_it) == '(')
                {
                    stack.pop_back();
                    stack.pop_back();
                }
            }
        }
        if (stack.size() != 0)
            cout<<"NO\n";
        else
            cout<<"YES\n";
    }
}