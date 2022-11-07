N = int(input())
arr = list(map(int,input().split()))
result = [arr[0]]
for i in range(1,N):
    temp = result[i-1] + arr[i]
    if result[i-1] > 0:
        result.append(temp)
        continue
    result.append(arr[i])
print(max(result))