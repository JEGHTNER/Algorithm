#include<iostream>
#include<stack>
#include<vector>
#include<algorithm>

using namespace std;

int n, m, r;


void dfs(vector<int> visited, vector<vector<int>> graph)
{
    stack<int> stack;
    int tmp;
    int depth = 0;
    stack.push(r);
    while (stack.size())
    {
        tmp = stack.top();
        stack.pop();
        if (!visited[tmp])
        {   
            depth += 1;
            visited[tmp] = depth;
            for (auto num : graph[tmp])
                stack.push(num);
        }
    }
    for (int i = 1; i < n + 1; i++)
        cout<<visited[i]<<"\n";
}

int main()
{
    cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);
    cin>>n>>m>>r;
    vector<int> visited(n + 1, 0);
    vector<vector<int>> graph(n + 1, vector<int>({}));

    int left, right;
    for (int i = 0; i < m; i++)
    {
        cin>>left>>right;
        graph[left].push_back(right);
        graph[right].push_back(left);
    }
    for (int i = 1; i < n + 1; i++)
        sort(graph[i].begin(), graph[i].end(), greater<int>());
    dfs(visited, graph);
    
}