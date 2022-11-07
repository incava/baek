N = int(input())
data=[]
minNum = 1000000000
for i in range(N):
    data.append(int(input()))
    minNum = min(minNum,data[i])

def dataCheck(data,N,i):
    temp = data[0] % i 
    for j in range(1,N):
        if temp != data[j] % i:
            return False
    return True

for i in range(2,minNum):
    if dataCheck(data,N,i):
        print(i,end=" ")


