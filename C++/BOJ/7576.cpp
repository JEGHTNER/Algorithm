#include<iostream>
#include<vector>
#include<deque>

using namespace std;

void    bfs(deque<vector<int>> queue, int **table, int width, int height)
{
    int x, y, count;
    int nx, ny, ncount;
    vector<int> tmp;
    vector<int> dx = {-1,0,1,0};
    vector<int> dy = {0,-1,0,1};
    while (queue.size())
    {
        tmp = queue.front();
        y = tmp[0];
        x = tmp[1];
        count = tmp[2];
        queue.pop_front();
        for (int i = 0; i < 4; i++)
        {
            nx = x + dx[i];
            ny = y + dy[i];
            ncount = count + 1;
            if (0 <= nx&& nx < width && 0 <= ny && ny < height)
            {
                if (table[ny][nx] == 0)
                {
                    table[ny][nx] = 1;
                    queue.push_back({ny,nx,ncount});
                }
            }
        }
    }
    for (int i = 0; i < height; i++)
    {    
        for (int j = 0; j < width; j++)
        {
            if (table[i][j] == 0)
            {    
                count = -1;
                break;
            }
        }
    }
    cout<<count;
}

int main()
{
    deque<vector<int>>  queue;
    int width, height;
    cin>>width>>height;
    int **table = new int *[height];
    for (int i = 0; i < height; i++)
        table[i] = new int[width];
    for (int i = 0; i < height; i++)
        for (int j = 0; j < width; j++)
        {
                cin>>table[i][j];
                if (table[i][j] == 1)
                    queue.push_back({i,j,0});
        }
    bfs(queue,table,width,height);
}