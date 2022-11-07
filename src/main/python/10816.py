N = int(input()) #첫번째값
arr = list(input().split())
dic = {} #map
for i in arr:
    if i in dic:
        dic[i] +=1
    else:
        dic[i]= 1  # key  =  value
M = int(input()) #3
arr2 = list(map(int,input().split())) #4

for i in arr2:
    print(dic.get(str(i),0),end=" ")
