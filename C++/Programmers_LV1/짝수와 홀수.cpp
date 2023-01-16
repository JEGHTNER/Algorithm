#include <string>
#include <vector>
#include <iostream>

using std::cout;
using std::endl;
using std::cin;

using namespace std;


string solution(int num) {
    string answer = "";
    if (num % 2 == 0)
        answer = "Even";
    else
        answer = "Odd";
    return answer;
}

