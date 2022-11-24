t = int(input())
arr = []
minNum = 0
maxNum = 0
goNum = []
def bfs(i,j,depth):   
    if arr[i][j]==1:
        temp = bfs(i,j,depth+1)
        minNum = min(temp,minNum)

for q in range(1,t+1):
    n = int(input())
    for i in range(n):
        tempArr = list(map(int,input().split()))
        for j in tempArr:
            if j ==1:
                goNum.append(list(i,j))
        arr.append(tempArr)
    visited = arr.copy()
    for i,j in goNum.items():
        bfs(i,j,)
