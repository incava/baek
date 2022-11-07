def dfs(depth):
    if depth == M:
        print(' '.join(map(str,answer)))
    else:
        for i in range(1,N+1):
                answer.append(i)
                dfs(depth+1)
                answer.pop()
N,M = map(int,input().split())
answer=[]
dfs(0)        