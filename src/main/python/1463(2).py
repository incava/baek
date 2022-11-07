N = int(input())

def dynamic(N):
    result = [0 for _ in range(N+1)] #0부터 N까지 
    for i in range(2,N+1): #4부터 N까지 돌리기.
        result[i] = result[i-1] + 1
        if i % 3 == 0:
            result[i] = min(result[i],result[i//3] + 1)
        if i % 2 == 0:
            result[i] = min(result[i],result[i//2] + 1)
    return result[N]
print(dynamic(N))