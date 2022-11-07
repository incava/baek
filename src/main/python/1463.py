N = int(input())

def dynamic(N):
    count = 0
    result = [N,N,N]
    while(min(result)!=1):
        arr = [result[0],result[1],result[2]]
        for j in range(3):
            if result[j] % 3 == 0:
                arr[0] = min(arr[0],result[j] // 3) #전거에서 3개 다 해본후 가장작은 값 저장.
            if result[j] % 2 == 0:
                arr[1] = min(arr[1],result[j] // 2) #전거에서 3개 다 해본후 가장작은 값 저장.
            arr[2] = min(arr[2],result[j]-1) #전거에서 3개 다 해본후 가장작은 값 저장.
        result = [arr[0],arr[1],arr[2]]
        count+=1
        print(result)
    return count
print(dynamic(N))