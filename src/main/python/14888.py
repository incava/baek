N = int(input())
arr=list(map(int,input().split()))
fun=list(map(int,input().split()))
min=1000000000
max=-1000000000
result=0

def dfs(result,depth):
    global min,max
    if depth == N:
        if result < min:
            min = result
        if result > max:
            max = result
        return
    for temp in range(4):
        if fun[temp]>0:
            fun[temp]-=1
            if temp == 0:
                dfs(result+arr[depth],depth+1)
            elif temp == 1:
                dfs(result-arr[depth],depth+1)
            elif temp == 2:
                dfs(result*arr[depth],depth+1)
            else:
                if result*arr[depth]>0: # 음수2개거나 양수 2개
                    dfs(abs(result)//abs(arr[depth]),depth+1)
                else:
                    dfs((abs(result)//abs(arr[depth]))*-1,depth+1)
            fun[temp]+=1
        
dfs(arr[0],1)
print(max)
print(min)
