def dfs(j,depth):
    if depth == M:
        print(' '.join(map(str,answer)))
    for i in range(j,N+1):
        if not visited[i]:
            if i > depth + N - M + 1: # 너무도 큰 경우
                continue
            if not answer:
                pass
            elif answer[-1] >= i: # 마지막이 i보다 크거나 같은경우.
                continue
            #터무니없이 큰값 제외, 빈값 , i가 전보다 큰경우
            visited[i]=True        
            answer.append(i)
            dfs(i+1,depth+1)
            visited[i]=False
            answer.pop()
N , M = map(int,input().split())
visited=[False for _ in range(N+1)]
answer = []                
dfs(1,0)
