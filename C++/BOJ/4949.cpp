#include<stack>
#include<iostream>
#include<stdio.h>
#include<string>
#include<map>
using namespace std;
int main()
{
    map<char, char> dic;
    dic[')'] = '(';
    dic[']'] = '[';
    while (1)
    {
        string str;
        stack<char> l_stack;
        stack<char> r_stack;
        cin>>str;
        //scanf("%s",str);
        if (str == ".")
            break;
        for (auto c : str)
        {
            if (c == '[' || c == '(')
                l_stack.push(c);
            if (c == ']' || c == ')')
            {
                r_stack.push(c);
                if (l_stack.top() == dic[r_stack.top()])
                {
                    l_stack.pop();
                    r_stack.pop();
                }
            }
        }
        if (l_stack.size() == 0 && r_stack.size() == 0)
            cout<<"yes\n";
        else
            cout<<"no\n";
    }
}