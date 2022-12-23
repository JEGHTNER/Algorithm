#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(int n) {
    int answer = 0;
    vector<bool> lst(n+1);

    fill(lst.begin(),lst.end(),true);
    lst[0] = false;
    lst[1] = false;
    for (int i = 2; i * i <= n; i++)
    {
        if (lst[i])
        {
            for (int j = i*i; j <= n; j += i)
            {
                lst[j] = false;
            }
        }
    }
    for(int i = 0 ; i < lst.size(); i ++)
        cout << lst[i];
    answer = count(lst.begin(),lst.end(),true);
    return answer;
}



int main()
{
    cout << solution(5)<<endl;
}