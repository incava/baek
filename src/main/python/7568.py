N = int(input())
data =[]
for i in range(N):
    x,y=map(int,input().split())
    data.append((x,y))
for i in data:
    count = 0
    for j in data:        
        if i[0] < j[0] and i[1] < j[1]:
            count = count + 1
    print(count+1,end=" ")