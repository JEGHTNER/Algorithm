#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(string input , char delimiter)
{
    vector<string> answer;
    stringstream ss(input);
    string tmp;

    while(getline(ss, tmp, delimiter))
        answer.push_back(tmp);
    return answer;
}

int main()
{
    int m;
    cin>>m;
    vector<pair<int, int>> lst;
    for (int i = 1; i <= 20; i++)
        lst.push_back(pair(i, 0));
    for (int i = 0; i < m; i++)
    {
        string read;
        cin >> read;
        if (read == "all")
        {
            for (int j = 0; j <= 20; j++)
                lst[j].second = 1;
        }
        else if (read == "empty")
        {
            for (int j = 0; j <= 20; j++)
                lst[j].second = 0;
        }
        else
        {
            vector<string> command = split(read, ' ');
            int num = stoi(command[1]);
            if (command[0] == "add")
                lst[num].second = 1;
            else if (command[0] == "check")
            {
                if (lst[num].second == 0)
                    cout << 0 <<"\n";
                else
                    cout << 1 << "\n";
            }
            else if (command[0] == "remove")
                lst[num].second = 0;
            else if (command[0] == "toggle")
            {
                if (lst[num].second == 0)
                    lst[num].second = 1;
                else
                    lst[num].second = 0;
            }
        }
    }
}