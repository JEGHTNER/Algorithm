#include <string>
#include <vector>
<<<<<<< HEAD
#include<iostream>
=======

>>>>>>> d88a41ffacc6b77a1080050d9e5e327edf8d1cab
using namespace std;

string solution(string s) {
    string answer = "";
    int len = s.length();
    if (len % 2 == 0) {
        answer.push_back(s[len / 2 - 1]);
        answer.push_back(s[len / 2]);
    }
    else
        answer.push_back(s[len / 2]);
    return answer;
<<<<<<< HEAD
}

int main()
{
    string s = "abcdef";
    cout << solution(s) << endl;
=======
>>>>>>> d88a41ffacc6b77a1080050d9e5e327edf8d1cab
}