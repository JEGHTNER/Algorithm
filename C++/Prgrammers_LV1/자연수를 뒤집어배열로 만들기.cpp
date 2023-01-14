#include<iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    string num = to_string(n);

    for (int i = 0; i < num.length(); i++)
        answer.push_back(num[i]-'0');
    reverse(answer.begin(), answer.end());
    return answer;
}

int main()
{
    vector<int> ans = solution(12345);
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << ' ';
    }
    cout << endl;
}
