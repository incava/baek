N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int,input().split())))

def cal(N,first): # N = N first는 전꺼 수
    minnum = 1000
    idx = 0
    for i in range(3):
        if i!=first:
            for j in range(3):
                if i!=j:
                    temp = arr[N][i]+arr[N+1][j]
                    if minnum > temp:
                        minnum = temp
                        idx = i
    return idx ,arr[N][idx]

def dynamic(N):
    result = 0
    first , minnum = cal(0,3)
    result+= minnum
    for i in range(1,N-1):
        first , minnum = cal(i,first)
        result+= minnum
    result+=min(arr[N-1][first-1],arr[N-1][first-2])
    return result
print(dynamic(N))


