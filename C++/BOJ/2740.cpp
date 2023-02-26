#include<iostream>
#include<vector>

using namespace std;

int N, M, K;


int main()
{
    int num;
    cin>>N>>M;
    vector<vector<int>> A(N, vector<int> {});
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin>>num;
            A[i].push_back(num);
        }
    }
    cin>>M>>K;
    vector<vector<int>> B(M, vector<int> {});
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < K; j++)
        {
            cin>>num;
            B[i].push_back(num);
        }
    }
    vector<vector<int>> AB(N, vector<int>(K, 0));
    for (int n = 0; n < N; n++)
    {
        for (int k = 0; k < K; k++)
        {
            for (int m = 0; m < M; m++)
                AB[n][k] += A[n][m] * B[m][k];
        }
    }
    for (auto v : AB)
    {
        for (auto num : v)
            cout<< num << " ";
        cout<<"\n";
    }
}