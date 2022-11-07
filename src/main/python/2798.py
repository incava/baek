N , M = map(int,input().split())
data = list(map(int,input().split()))
#브루트 포스로 하기.
def answer(M):
    temp = 0
    for i in range (len(data)-2):
        for j in range(i+1,(len(data))-1):
            for k in range(j+1,(len(data))):
                answer = data[i] + data[j] + data[k] 
                if (answer == M):
                    return M
                elif (answer < M) and (answer > temp) :
                    temp = answer
    return temp                
print (answer(M))