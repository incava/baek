import sys
input = sys.stdin.readline
N,M = map(int,input().split())#첫번째값
dic = {} #map
for i in range(1,N+1):
    temp = input().strip()
    dic[temp] = i
    dic[str(i)] = temp
print(dic)
for i in range(0,M):
    j = input().strip()
    print(dic.get(j))
        










'''
N,M = map(int,input().split())#첫번째값
dic = {} #map
dic2 = {} # map reverse
count = 0
for i in range(1,N+1):
    k = input()
    dic[k] = i  # key  =  value 문자,숫자
    dic2[str(i)] = k # value = key  숫자, 문자
arr=[]
for i in range(M):
    arr.append(input())
for i in arr:
    if i.isalpha():
        print(dic.get(i)) # 숫자
    else:
        print(dic2.get(i)) #문자'''