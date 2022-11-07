N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int,input().split())))

def dynamic(N):
    dp = [[0] * (i+1) for i in range(1,N+1)]
    dp[0][0] = arr[0][0]
    for i in range(1,N):# 행과 갯수
        dp[i][0] = arr[i][0] + dp[i-1][0]
        for j in range(1,i+1): # 번째
            dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j]    
    return max(dp[N-1])

print(dynamic(N))