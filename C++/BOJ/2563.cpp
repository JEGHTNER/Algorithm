#include<iostream>

using namespace std;

int n;
int arr[101][101] = {0,};
int cnt = 0;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>n;
    for (int i = 0; i < n; i++)
    {
        int x, y;
        cin>>x>>y;
        for (int j = x; j < x+10; j++)
        {
            for (int k = y; k < y+10; k++)
            {
                if (arr[j][k] == 0)
                {
                    cnt++;
                    arr[j][k] = 1;
                }
            }
        }
    }
    cout<<cnt;
}
