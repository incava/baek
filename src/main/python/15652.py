import sys
def dfs(j,depth):
    if depth == M:
        print(*answer)
    else:
        for i in range(j,N+1):
                answer.append(i)
                dfs(i,depth+1)
                answer.pop()
input = sys.stdin.readline
N,M = map(int,input().split())
answer=[]
dfs(1,0)   