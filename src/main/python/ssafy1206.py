def check(i):
    flag = False
    temp = max(arr[i-2],arr[i-1],arr[i+2],arr[i+1])
    if arr[i]<=temp:
        flag = True
    return flag, arr[i] - temp
for q in range(1,11):
    n = int(input())
    arr = list(map(int,input().split()))
    result = 0
    for i in range(2,n-2):
        flag, temp = check(i)
        if flag == True:
            continue
        else:
            result+=temp
    print("#%d %d" %(q,result))