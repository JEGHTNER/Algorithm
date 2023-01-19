#include<iostream>
#include<vector>
#include<stack>
#include<deque>
using namespace std;

void dfs(vector<bool> *visited, int v, vector<vector<int>> graph)
{
    stack<int>  stack;
    stack.push(v);
    (*visited)[v] = true;
    while (stack.size())
    {
        int i = stack.top();
        stack.pop();
        for (auto j : graph[i])
        {
            if ((*visited)[j] == false)
            {
                stack.push(j);
                (*visited)[j] = true;
            }
        }
    }
}

void bfs(vector<bool> *visited, int v, vector<vector<int>> graph)
{
    deque<int>  queue;
    queue.push_back(v);
    while (queue.size())
    {
        int i = queue.front();
        queue.pop_front();
        for (auto j : graph[i])
        {
            if ((*visited)[j] == false)
            {
                queue.push_back(j);
                (*visited)[j] = true;
            }
        }
    }
}

int main()
{
    int dots, lines;
    cin >> dots>> lines;
    int u, v;
    int count = 0;
    vector<bool> visited;
    vector<vector<int>>  graph;
    for(int i = 0; i <= dots; i++)
    {
        visited.push_back(false);
        graph.push_back({});
    }
    for(int i = 0; i < lines; i++)
    {
        cin>> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    for(int v = 1; v <= dots; v++)
    {
        if (visited[v] == true) continue;
        //dfs(&visited, v, graph);
        bfs(&visited,v,graph);
        count++;
    }
    cout<<count;
}