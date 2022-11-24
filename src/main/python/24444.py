from collections import deque


n,m,r = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
for i in range(n):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n+1):
    graph[i].sort()


def bfs(graph,R,visited):
    queue = deque([R])
    visited[R] = 1
    cnt = 2
    while queue:
        R = queue.popleft()
        for i in graph[R]:
            if visited[i]==0:
                queue.append(i)
                visited[i] = cnt
                cnt+=1
bfs(graph,r,visited)                
print(*visited[1:],sep="\n")