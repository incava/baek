from math import sqrt
m = 123456 * 2
sosu=[False,False] + [True] * (m-1) #sosu[m]
for i in range (2,int(sqrt(m))+1):
    if sosu[i] == True:
        for j in range(i*2,m+1,i):
            sosu[j] = False


while(True):
    n = int(input())
    count = 0
    if n == 0:
        break
    for k in range(n+1,2*n+1):
        if sosu[k] == True:
            count = count + 1
    print(count)