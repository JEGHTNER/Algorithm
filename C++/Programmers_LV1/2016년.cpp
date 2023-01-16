#include <string>
#include <vector>

using namespace std;

int day_count(int month, int day)
{
    int total_day = 0;
    int iter = 1;

    while (iter < month)
    {
        if (iter == 2)
            total_day += 29;
        else if (iter == 1 || 3 || 5 || 7 || 8 || 10 || 12)
            total_day += 31;
        else
            total_day += 30;
        iter++;
    }
    return (total_day + day - 1);
}

string solution(int a, int b) {
    string answer = "";
    vector<string> week = { "SUN", "MON", "TUE", "WED","THU", "FRI", "SAT" };
    answer += week[(5 + day_count(a, b) % 7)];
    return answer;
}

int main()
{
    cout << solution(5, 24);
}