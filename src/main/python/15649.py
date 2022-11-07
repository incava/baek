def dfs(depth,n,m):
    if depth == m:
        print(' '.join(map(str,answer)))
    else:
        for i in range(1,n+1):
            if not visited[i]:
                visited[i] = True
                answer.append(i)
                dfs(depth+1,n,m)
                visited[i]=False
                answer.pop()
N,M = map(int,input().split())
answer=[]
visited = [False for i in range(N+1)] #0포함.
#visited = [False] * (N+1)
dfs(0,N,M)        