import sys
input = sys.stdin.readline
N,M = map(int,input().split())
dic = {}
arr = []
for i in range(N):
    dic[input().strip()] = 1

for j in range(M):
    m = input().strip()
    if m in dic:
        arr.append(m)
arr.sort()
print(len(arr))
for i in arr:
    print(i)

