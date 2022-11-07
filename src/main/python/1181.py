import sys
input = sys.stdin.readline 
N = int(input())
Arr = []
for i in range(N):
    Arr.append(input())
Arr = list(set(Arr))
Arr.sort() #사전정렬
Arr.sort(key=len) #길이정렬
for i in Arr:
    print(i,end="")
