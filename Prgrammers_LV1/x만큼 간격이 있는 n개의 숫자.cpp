#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    int num= x;
    for (int i = 0; i < n; i++)
    {
        answer.push_back(num);
        num += x;
    }
    return answer;
}

void printVector(vector<long long> solution)
{
    for (int i = 0; i < solution.size(); i++)
    {
        cout << solution[i]<< " ";
    }
    cout << endl;
}
int main()
{
    printVector(solution(2, 5));
    printVector(solution(4, 3));
    printVector(solution(-4, 2));
    
}