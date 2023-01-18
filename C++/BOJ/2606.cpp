#include <iostream>
#include <vector>
#include <stack>
#include <deque>
using namespace std;

void dfs(vector<vector<int>> graph, vector<int> infected)
{
    stack<int> stack;
    stack.push(1);

    while (stack.size() >= 1)
    {
        int i = stack.top();
        stack.pop();
        if (find(infected.begin(), infected.end(),i) == infected.end())
        {
            infected.push_back(i);
            for (auto it : graph[i])
                stack.push(it);
        }
    }
    cout<<infected.size() - 1;
}

void    bfs(vector<vector<int>> graph, vector<int> infected)
{
    deque<int>  queue;

    queue.push_back(1);
    while (queue.size() >= 1)
    {
        int i = queue.front();
        queue.pop_front();
        if (find(infected.begin(), infected.end(), i) == infected.end())
        {
            infected.push_back(i);
            for(auto it :graph[i])
                queue.push_back(it);
        }
    }
    cout<<infected.size() - 1;
}

int main()
{
    int computers;
    cin>>computers;
    int pair_len;
    cin>> pair_len;
    int left, right;
    vector<vector<int>> graph;
    vector<int> infected;
    for(int i = 0; i < computers + 1; i++)
        graph.push_back({});
    for (int i = 0; i < pair_len; i++)
    {
        cin>>left>>right;
        graph[left].push_back(right);
        graph[right].push_back(left);
    }
    dfs(graph, infected);
    bfs(graph, infected);
}