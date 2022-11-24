n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
for i in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n+1):
    graph[i].sort(reverse=True)

def dfs(graph,r,visited):
    stack = [r]
    visited[r] = 1
    cnt = 2
    while stack:
        now = stack.pop()
        for i in graph[now]:
            if visited[i] == 0:
                stack.append(i)
                visited[i] = cnt
                cnt+=1
dfs(graph,1,visited)
result = 0
for i in visited[2:]:
    if i!=0:
        result+=1
print(result)        