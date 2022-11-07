n = int(input())
arr = [0] + list(map(int,input().split()))
total = 0
arr.sort()
print(arr)
for i in range(1,n+1):
    arr[i] += arr[i-1]
    total += arr[i]
print(arr)
print(total)