#include <vector>
#include <iostream>
#include <algorithm>
#include <numeric>
using namespace std;

bool is_prime(int num)
{
    vector<int> lst(num + 1);

    fill(lst.begin(),lst.end(),true);
    lst[0] = false;
    lst[1] = false;
    for (int i = 2; i * i <= num; i++)
    {
        if (lst[i])
            for (int j = i * i; j<= num; j+=i)
            {
                lst[j] = false;
            }
    }
    if (lst[num] == true)
        return true;
    return false;
}

int solution(vector<int> nums) {
    int answer = 0;
    vector<int> tmp={};
    vector<vector<int>> comb = {};
    vector<int> visited;

    for (int i = 0; i < 3; i++)
        visited.push_back(1);
    for (int i = 0; i < nums.size() - 3; i++)
        visited.push_back(0);
    sort(visited.begin(), visited.end());
    do{
        for (int i = 0; i< visited.size(); i ++)
        {
            if (visited[i] == 1)
            {
                tmp.push_back(nums[i]);
            }
        }
        comb.push_back(tmp);
        tmp.clear();
    }while(next_permutation(visited.begin(),visited.end()));
    for (int i = 0; i< comb.size(); i ++)
    {   
        int sum = 0;
        sum = is_prime(accumulate(comb[i].begin(), comb[i].end(), 0));
        if(sum == 1)
            answer++;
    }
    return answer;
}

#include<iostream>
int main()
{
    cout << solution({1,2,7,6,4});
}

