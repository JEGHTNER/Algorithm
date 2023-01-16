#include <string>
#include <cmath>
#include <iostream>
#include <vector>
#include <numeric>

using namespace std;


bool check_bonus(char c)
{
    if (c == 'S' || c == 'D' || c == 'T')
        return true;
    return false;
}

int parse_bonus(string tmp, char c)
{
    int num = stoi(tmp);

    if (c == 'S')
        return num;
    if (c == 'D')
        return pow(num, 2);
    if (c == 'T')
        return pow(num ,3);
    return num;
}
bool check_option(char c)
{
    if (c == '*' || c == '#')
        return true;
    return false;
}
void parse_option(vector<int> *lst, char c)
{
    vector<int> *tmp = lst;

    if (c == '*')
    {
        *((*tmp).end() - 1) *=2 ;
        if ((*tmp).size() > 1)
            *((*tmp).end() - 2) *= 2;
    }
    if (c == '#')
        *((*tmp).end() - 1) *= -1;
}


int solution(string dartResult) {
    int answer = 0;
    string tmp ="";
    vector<int> lst;

    for (int i = 0; i < dartResult.size(); i++)
    {
        if (isdigit(dartResult[i]))
            tmp += dartResult[i];
        else if (check_bonus(dartResult[i]))
        {
            lst.push_back(parse_bonus(tmp, dartResult[i]));
            tmp ="";
        }
        else if (check_option(dartResult[i]))
            parse_option(&lst, dartResult[i]);
    }
    answer = accumulate(lst.begin(), lst.end(), 0);
    return answer;
}

int main()
{
    cout << solution("1S2D*3T");
}