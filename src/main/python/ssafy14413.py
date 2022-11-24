t = int(input())
for tc in range(1,t+1):
    n,m = map(int,input().split())
    arr = []
    def check(arr,n,m,a):
        for i in range(n):
            for j in range(m):
                if a == 0: #짝수가 #임
                    if (i+j)%2==0:#흰색
                        if arr[i][j]=='.': # 흰색
                            return False
                    if (i+j)%2==1:#검정색
                        if arr[i][j]=='#': # 검정색
                            return False
                if a == 1: #짝수가 .임
                    if (i+j)%2==0:#검정색
                        if arr[i][j]=='#': # 검정색
                            return False
                    if (i+j)%2==1:#흰색
                        if arr[i][j]=='.': # 흰색
                            return False
        return True
    for i in range(n):
        arr.append(list(input()))
    print("#%d %s" %(tc,'possible' if check(arr,n,m,0) or check(arr,n,m,1) else 'impossible'))