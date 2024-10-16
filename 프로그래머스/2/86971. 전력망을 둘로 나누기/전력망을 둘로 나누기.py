from collections import deque
N = 0
def solution(n, wires):
    global N
    N = n
    visited =[False for i in range(n + 1)]
    answer = 99999
    graph = [ [] for i in range(n + 1)]
    for s, e in wires:
        graph[s].append(e)
        graph[e].append(s)
    for s, e in wires:
        graph[s].remove(e)
        graph[e].remove(s)
        # print(graph)
        a = bfs(s, graph)
        b = bfs(e, graph)
        # print("a ",a,"b",b)
        answer = min(answer, abs(a - b))
        graph[s].append(e)
        graph[e].append(s)
        pass
    return answer

def bfs(start, graph):
    # print("start = ",start)
    visited = [0 for i in range(N + 1)]
    queue = deque()
    queue.append(start)
    while queue:
        # print("queue = ", queue)
        cur = queue.popleft()
        # print("cur = ",cur)
        if visited[cur] == 1:
            continue
        visited[cur] = 1
        for node in graph[cur]:
            queue.append(node)
            # visited[node] = 1
    # print(visited)
    return sum(visited)
    