# import sys
# sys.setrecursionlimit(10**6)
# input = sys.stdin.readline
# n,m,r = map(int,input().split())
# graph = [[] for _ in range(n+1)]
# visited = [0] * (n+1)
# cnt = 1
# for i in range(m):
#     u,v = map(int,input().split())
#     graph[u].append(v)
#     graph[v].append(u)
    
# def dfs(e):
#     global cnt
#     visited[e] = cnt
#     graph[e].sort()
#     for i in graph[e]:
#         if visited[i] == 0:
#             cnt+=1
#             dfs(i)
# dfs(r)
# print(*visited[1:],sep='\n')

import sys
input = sys.stdin.readline
n,m,r = map(int,input().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)
for i in range(1,len(graph)):    
    graph[i].sort(reverse=True)
def dfs(e):
    stack = [e]
    visited = [-1]*(n+1)
    result = [0]*(n+1) 
    cnt = 1
    while stack:
        cnt_node = stack.pop()
        if visited[cnt_node] == 1:
            continue
        visited[cnt_node] = 1
        result[cnt_node] = cnt
        cnt +=1
        for i in graph[cnt_node]:
            if visited[i] == -1:
                stack.append(i)
    return result            


result = dfs(r)

print(*result[1:],sep='\n')