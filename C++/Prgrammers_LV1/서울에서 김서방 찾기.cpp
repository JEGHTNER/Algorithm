#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    int index;
    for (int i = 0; i < seoul.size(); i++)
    {
        if (seoul[i] == "Kim")
            index = i;
    }
    
    answer = "김서방은 " + to_string(index) +"에 있다";
    return answer;
}   

int main()
{
    vector<string> seoul = { "Jane","Kim" };
    cout << solution(seoul);
}