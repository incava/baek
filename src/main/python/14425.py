N,M = map(int,input().split())#첫번째값
dic = {} #map
count = 0
for i in range(N):
    dic[input()]= 1  # key  =  value
arr=[]
for i in range(M):
    arr.append(input())
for i in arr:
    if i in dic: #빅오로 N(1)
        count +=1
print(count)