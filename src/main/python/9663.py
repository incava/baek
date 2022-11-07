def crossCheck(x): # 가능하면 1 겹치면 0
    for i in range(x):
        if answer[x] == answer[i] or abs(answer[x] - answer[i]) == x - i:
            return 0
    return 1

def dfs(depth):
    global cnt
    if depth == N:
        cnt+=1
        return
    for j in range(N): # j는 열 depth는 행을 의미
        answer[depth] = j
        if crossCheck(depth):
            dfs(depth+1)
N = int(input())
answer=[0]*N
cnt = 0
dfs(0)
print(cnt)



# def crossCheck(x,y): # 가능하면 1 겹치면 0 z는 +방향
#     for i in range(len(answer)):
#         x1,y1 = answer[i]
#         if abs(x1-x) == abs(y1-y) or x1 == x or y1 == y:
#             return 0
#     return 1

# def dfs(i,depth):
#     global cnt
#     if depth == N:
#         cnt+=1
#     else:
#         for j in range(N):
#             if crossCheck(i,j):
#                 answer.append(list(map(int,(i,j))))
#                 dfs(i+1,depth+1)
#                 answer.pop()
# N = int(input())
# answer=[]
# cnt = 0
# dfs(0,0)
# print(cnt)