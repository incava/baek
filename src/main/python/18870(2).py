import sys
input = sys.stdin.readline
N = int(input())
arr = []
arr = list(map(int,input().split())) # N번 스플릿
Arr = sorted(set(arr)) #N+N^2
dic = {}
for i in range(len(Arr)): #N
    dic[Arr[i]] = i

for i in arr: #N번
    print(dic[i], end=' ')