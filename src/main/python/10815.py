N = int(input()) #첫번째값
arr = list(map(int,input().split())) # 6 3 2 10 -10을 공백으로 띄워서 list로 만들어서 arr에 저장
dic = {} #map
for i in range(N):
    dic[arr[i]]= 1  # key  =  value
M = int(input()) #3
arr2 = list(map(int,input().split())) #4

for i in arr2:
    if i in dic: #빅오로 N(1)
        print(1,end=" ")
    else:
        print(0,end=" ")