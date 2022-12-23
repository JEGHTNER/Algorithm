#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<bool> lst={true,};

    lst[0], lst[1] = false, false;
    for (int i = 2; i * i <= n; i++)
    {
        if (lst[i])
        {
            for (int j = i*i; j <= n; j += i)
            {
                lst[j] = false
            }
        }
    }
    return answer;
}

#include <iostream>

int main()
{
    cout << solution(10)<<endl;
}