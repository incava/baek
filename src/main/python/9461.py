N = int(input())
arr=[0] * 101
arr[1] = arr[2] = arr[3] = 1 
def padoban(M):
    for i in range(4,M+1):
        arr[i] = arr[i-3] + arr[i-2]
    return str(arr[M])
    
for i in range(N):
    print(len(padoban(int(input())))) 