#include <string>
#include <vector>

using namespace std;

int solution(string s) 
{
    int flag = 1;
    char x;
    int x_count = 0;
    int else_count = 0;
    vector<string> answer = {};
    string  tmp ="";
    
    for (auto c : s)
    {
        if (flag == 1)
        {
            x = c;
            flag = 0;
        }
        if (c == x)
        {
            x_count++;
            tmp += c;
        }
        if (c != x)
        {
            else_count++;
            tmp += c;
        }
        if (else_count == x_count)
        {
            answer.push_back(tmp);
            tmp = "";
            x_count = 0;
            else_count = 0;
            flag = 1;
        }
    }
    if (x_count != else_count)
        answer.push_back(tmp);

    return answer.size();
}

#include<iostream>
int main()
{
    string s = "abracadabra";
    cout << solution(s);    
}