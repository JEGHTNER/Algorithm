#include<iostream>
#include<vector>

using namespace std;

void    dfs(vector<vector<int>> *table, int y, int x , int height, int width)
{
    if (y < 0 || y >= height || x < 0 || x >= width)
        return ;
    if ((*table)[y][x] == 0)
        return ;
    if ((*table)[y][x] == 1)
    {
        (*table)[y][x] = -1;
        dfs(table,y + 1, x ,height, width);
        dfs(table,y, x + 1 ,height, width);
        dfs(table,y - 1, x ,height, width);
        dfs(table,y, x - 1 ,height, width);
    }
}

int main()
{
    int t;
    cin >> t;
    for (int tc = 0; tc < t; tc++)
    {
        int m, n, cabbage_len;
        int x, y;
        int count = 0;
        cin >> m>> n>> cabbage_len;
        vector<vector<int>> table(n,vector<int>(m,0));

        for (int i = 0; i < cabbage_len; i++)
        {
            cin >> x>> y;
            table[y][x] = 1;
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (table[i][j] == 1)
                {
                    dfs(&table,i,j,n,m);
                    count++;
                }
            }
        }
        // for (int i = 0; i < table.size(); i++)
        // {
        //     for (int j = 0; j < table[i].size(); j++)
        //         cout <<table[i][j]<<" ";
        //     cout<<"\n";
        // }
        cout<<count<<"\n";
    }
}