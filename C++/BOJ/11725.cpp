#include<iostream>
#include<vector>
#include<deque>
using namespace std;

void    bfs(vector<vector<int>> graph, vector<int> ans)
{
    int current;
    deque<int> queue;
    queue.push_back(1);
    while(queue.size())
    {
        current = queue.front();
        queue.pop_front();
        for (auto num : graph[current])
            if (ans[num] == 0)
            {
                ans[num] = current;
                queue.push_back(num);
            }
    }
    for (int i = 2; i < ans.size(); i++)
        cout<<ans[i]<<"\n";
}

int main()
{
    int n;
    int left, right;
    vector<vector<int>> graph;
    vector<int> ans;
    cin>>n;
    for (int i = 0; i <= n; i++)
    {
        graph.push_back({});
        ans.push_back(0);
    }
    for (int i = 1; i < n; i++)
    {
        cin>>left>>right;
        graph[left].push_back(right);
        graph[right].push_back(left);
    }
    bfs(graph, ans);

}