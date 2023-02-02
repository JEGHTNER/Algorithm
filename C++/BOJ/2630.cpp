#include<iostream>
#include<vector>

using namespace std;

int blue = 0;
int white = 0;

void recur(vector<vector<int>> square, int y, int x, int size)
{
    int color = square[y][x];
    for (int i = y; i < y + size; i++)
    {
        for (int j = x; j < x + size; j++)
        {
            if (color != square[i][j])
            {
                recur(square, y, x, size/2);
                recur(square, y, x + size/2, size/2);
                recur(square, y + size/2, x, size/2);
                recur(square, y + size/2, x + size/2, size/2);
                return ;
            }
        }
    }
    if (color == 0)
        white++;
    else
        blue++;
}

int main()
{
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);
    vector<vector<int>> square;
    int n;
    cin>>n;
    vector<int> line;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int num;
            cin>>num;
            line.push_back(num);
        }
        square.push_back(line);
    }
    recur(square,0,0,n);
    cout<<white<<"\n"<<blue<<"\n";
}