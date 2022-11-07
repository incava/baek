from math import sqrt
M,N = map(int,input().split())
for i in range(M,N+1):
    flag = False
    if i == 1:
        flag = True
    else:
        for j in range(2,int(sqrt(i))+1):
            if i % j == 0:
                flag = True
                    # 소수가 아니다.
                break
    if flag == False:
        print(i)