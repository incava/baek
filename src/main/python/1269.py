import sys
input = sys.stdin.readline
N , M = map(int,input().split())
dic = {}
count = 0
arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))

for i in arr1:
    dic[i] = 1

for i in arr2:
    if i in dic:
        count+=1

print(N + M - count*2)