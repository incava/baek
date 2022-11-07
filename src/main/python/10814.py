import sys
input=sys.stdin.readline
N = int(input())
arr = []
for i in range(N):
    x, y =input().split()
    arr.append((int(x),y))
arr.sort(key=lambda x:(x[0]))

for i in arr:
    print(i[0],i[1])
