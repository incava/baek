N = int(input())
arr = []
team1=[]
min=100*N
for i in range(N):
    arr.append(list(map(int,input().split())))

def teamScore(team1,team2):
    team1Score=0
    team2Score=0
    for i in team1:
        for j in team1:
            team1Score+=arr[i][j]
    for i in team2:
        for j in team2:
            team2Score+=arr[i][j]
    return abs(team1Score-team2Score)
      
def dfs(j,depth):            
    global min
    if depth == N//2:
        team2=[]
        for i in range(N):
            if i not in team1:
                team2.append(i)
        temp = teamScore(team1,team2)
        print(team1,team2,temp)    
        if min > temp:
            min = temp
        return
    for i in range(j,N):
        team1.append(i)
        dfs(i+1,depth+1)
        team1.pop()       
dfs(0,0)
print(min)