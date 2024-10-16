from collections import deque

class vertex:
    def __init__(self, start, end):
        self.start=start
        self.end=end
    
    def __repr__(self):
        return f"{self.start} {self.end}"
        
def solution(n, edge):
    answer = 0
    graph = [ [] for _ in range(n + 1)]
    for e in edge:
        start = e[0]
        end = e[1]
        graph[start].append(end)
        graph[end].append(start)
    # print(graph)
    answer = bfs(1, n, graph)
    return answer

def bfs(start, n, graph):
    queue = deque()
    queue.append(start)
    visited = [0 for _ in range(n + 1)]
    visited[1] = 1
    while queue:
        cur = queue.popleft()
        for v in graph[cur]:
            if visited[v] != 0:
                continue
            queue.append(v)
            visited[v] = visited[cur] + 1
    
    return(visited.count(max(visited)))