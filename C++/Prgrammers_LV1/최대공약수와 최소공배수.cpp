#include <string>
#include <vector>
#include<iostream>
#include<numeric>
#include<algorithm>
using namespace std;

int gcd(int a, int b)
{
    if (b == 0)
        return a;
    else
        return(gcd(b, a % b));
}
int lcm(int a, int b)
{
    return(a * (b / gcd(a, b)));
}
vector<int> solution(int n, int m) {
    vector<int> answer;
    answer.push_back(gcd(n, m));
    answer.push_back(lcm(n, m));
    
     
    return answer;
}

int main() {
    int n = 3, m = 12;
    cout<< solution(n, m)[0] <<" " << solution(n, m)[1] << endl;
}