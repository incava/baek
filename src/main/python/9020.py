from math import sqrt
m = 10000
sosu=[False,False] + [True] * (m-1) #sosu[m] 
for i in range (2,int(sqrt(m))+1):
    if sosu[i] == True:
        for j in range(i*2,m+1,i):
            sosu[j] = False

T = int(input())
for j in range(T):
    n = int(input())
    for i in range(n//2,1,-1):
        if sosu[i] and sosu[n - i] == True:
            print(i,n-i)
            break