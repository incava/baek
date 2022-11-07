N, M = map(int,input().split())
chess=[]
for i in range(N):
    chess.append(list(input()))

def chessmin(l,k): #8x8 체스판에서의 min값 도출 def
    countB,countW = 0,0
    for i in range(l,8+l): # 행
        for j in range(k,8+k): #열
            if (i+j)%2 == 0: #짝수가 되어야한다. W가 즉 맞다.
                if chess[i][j] !='W': #B이다? 
                    countB = countB + 1
                if chess[i][j] !='B': # W다?
                    countW = countW + 1
            else:
                if chess[i][j] !='B': #B이다? 
                    countB = countB + 1
                if chess[i][j] !='W': # W다?
                    countW = countW + 1
    return min(countB,countW)
minn=100000
for i in range(N-7):
    for j in range(M-7):
        temp = chessmin(i,j)
        if minn > temp:
            minn = temp
print(minn)
