n,m = map(int,input().split())
arr = []
cnt = 0
for i in range(n):
    arr.append(int(input()))
i = len(arr)-1
while(m):
    cnt += m//arr[i] #동전몫
    m %= arr[i]
    i-=1
print(cnt)