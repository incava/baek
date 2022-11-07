N = int(input())
data=[]
minNum=1000
for i in range(N):
    data.append(int(input()))

for i in range(N): # 
    for j in range(N-1):
        if data[j] > data[j+1]:
            temp = data[j+1]
            data[j+1] = data[j]
            data[j] = temp

for i in range(N):
    print(data[i])

