import sys
input=sys.stdin.readline
N = int(input())
list = []
for i in range(N):
    x,y = map(int,input().split())
    list.append((x,y))
list.sort(key = lambda x : (x[1],x[0]))
for i in range(N):
        print(list[i][0],list[i][1])