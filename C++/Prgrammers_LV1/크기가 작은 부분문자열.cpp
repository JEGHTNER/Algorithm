#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string t, string p) {
    int answer = 0;
    string  tmp = "";
    for (int i = 0; i < t.size() - p.size() + 1; i++)
    {
        tmp = t.substr(i , p.size());
        cout << tmp<<" ";
        if (tmp <= p)
            answer++;
    }
    return answer;
}



int main()
{
    cout << solution("3141592","271");
}
